package com.example.demo.service;

import com.example.demo.Dao.CommentDao;
import com.example.demo.Dao.OrderDao;
import com.example.demo.Dao.RoomDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.po.Comment;
import com.example.demo.po.Order;
import com.example.demo.po.Room;
import com.example.demo.po.User;
import com.example.demo.vo.CommentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    public String add(Comment comment) {
        Order o = orderDao.findById(comment.getOrder_Id()).get();

        if(o!=null&&!o.isStatus()){
            comment.setUser_Id(o.getUser_Id());
            comment.setRoom_Id(o.getRoom_Id());
            orderDao.updateCommentStatus(false,o.getId());
            commentDao.save(comment);
            return "评论成功";
        }else{
            return "订单未结束或者订单号错误";
        }
    }

    @Override
    public List<Comment> findByQuery(CommentQuery commentQuery) {
//        if (commentQuery.getOrder_Id() != null) {
//            return assemble(commentDao.findByOrder_Id(commentQuery.getOrder_Id()));
//        } else
        if (commentQuery.getUser_Id() != null) {
            return assemble(commentDao.findByUser_Id(commentQuery.getUser_Id()));
        } else if (commentQuery.getRoom_Id() != null) {
            return assemble(commentDao.findByRoom_Id(commentQuery.getRoom_Id()));
        } else {
            return assemble(commentDao.findAll());
        }
    }

    @Override
    public List<Comment> findAll() {
        return this.assemble(commentDao.findAll());
    }


    public List<Comment> assemble(List<Comment> allList){
        //声明父类容器
        List<Comment> parentsList = new ArrayList<>();
        //声明返回集合
        List<Comment> resultList = new ArrayList<>();
        for (Comment comment : allList) {
            //判断是否是第一梯队，或者说是树的根节点，如果是根节点就加入到父类集合与返回集合
            if (comment.getParent_Id() == null) {
                parentsList.add(comment);
                resultList.add(comment);
            } else {
                //对于不是第一梯队的数据进行遍历
                for (Comment parent : parentsList) {
                    //对数据的pid与父类集合中的父节点进行配对，如果配对成功，就把数据加入到父节点中的子节点集合
                    if (parent.getId().equals(comment.getParent_Id())) {
                        parent.getChildren().add(comment);
                        //当前数据有可能是别的数据的父节点，加到父类容器
                        parentsList.add(comment);
                        break;
                    }
                }
            }
        }
        return resultList;

    }
}
