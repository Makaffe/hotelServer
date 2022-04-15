package com.example.demo.service;

import com.example.demo.Dao.RoomDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.po.Room;
import com.example.demo.po.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public void add(Room room) {
        room.setDel_flag("0");
        roomDao.save(room);
    }

    @Override
    public List findAll() {
        List<Room> allList = roomDao.findAll();
        //声明父类容器
        List<Room> parentsList = new ArrayList<>();
        //声明返回集合
        List<Room> resultList = new ArrayList<>();

        for (Room room : allList) {

                //判断是否是第一梯队，或者说是树的根节点，如果是根节点就加入到父类集合与返回集合
                if (room.getParent_Id() == null) {
                    parentsList.add(room);
                    resultList.add(room);
                } else {
                    //对于不是第一梯队的数据进行遍历
                    for (Room parent : parentsList) {
                        //对数据的pid与父类集合中的父节点进行配对，如果配对成功，就把数据加入到父节点中的子节点集合
                        if (parent.getId().equals(room.getParent_Id())) {
                            parent.getChildren().add(room);
//                        当前数据有可能是别的数据的父节点，加到父类容器
//                        parentsList.add(room);
                            break;
                        }
                    }

            }
        }
        return resultList;
    }

    @Override
    public String delete(Long Id) {
        if(roomDao.findById(Id).get().getParent_Id()!=null){
            roomDao.delRoom(Id);
            return "删除成功";
        }else{
            List<Room> allList = roomDao.findAll();

            for(Room room : allList){
                //遍历所有房间，如果有房间的父Id和传入的Id相同则无法删除
                if(room.getParent_Id()==Id){
                    return "该楼层含有其他房间，无法删除";
                }
            }
            roomDao.delete(roomDao.findById(Id).get());
            return "删除成功";

        }

    }

    @Override
    public String update(Long Id, Room room) {
        Room r = roomDao.findById(Id).get();
        if(r!=null){
            BeanUtils.copyProperties(room,r);
            roomDao.save(r);
            return "更新成功";
        }else{
            return "没有找到该数据";
        }

    }

    @Override
    public Room findById(Long Id) {
        Room r = roomDao.findById(Id).get();
        if ( r != null) {
            if(r.getParent_Id()!=null){
                return r;
            }else{
                //判断是否柚
                List<Room> allList = roomDao.findAll();
                for(Room room : allList){
                    if(room.getParent_Id()==r.getId()){
                        r.getChildren().add(room);
                    }
                }
                return r;
            }
        } else {
            return null;
        }
    }

    @Override
    public List<Room> findAllByNotTree(){
        return roomDao.findAll();
    }
}
