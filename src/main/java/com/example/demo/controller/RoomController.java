package com.example.demo.controller;

import com.example.demo.Dao.RoomDao;
import com.example.demo.po.Room;
import com.example.demo.po.User;
import com.example.demo.service.RoomService;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="房间实体类",tags = {"房间管理"})
@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @ApiOperation("新增房间")
    @PostMapping("/add")
    public Room add(@RequestBody Room room){
        roomService.add(room);
        return room;
    }

    @ApiOperation("查询所有房间")
    @GetMapping("/findAll")
    public List findAll(){
        return roomService.findAll();
    }

    @ApiOperation("删除某一个房间，删除楼层的话，需要保证关联的房间已经删除")
    @DeleteMapping("/delete/{id}")
    public Room delete(@PathVariable("id") Long Id){

        Room r = roomService.findById(Id);
        roomService.delete(Id);
        return r;
    }

    @ApiOperation("更新房间或大厅")
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") Long Id, @ApiParam("房间") Room room){
        return roomService.update(Id,room);
    }


    @ApiOperation("根据Id查询房间或大厅")
    @GetMapping("/findById/{id}")
    public Room findById(@PathVariable("id") Long Id){
        return roomService.findById(Id);
    }

    @ApiOperation("不生成树形结构的房间查询")
    @GetMapping("/findAllByNotTree")
    public List<Room> findAllByNotTree(){
        return roomService.findAllByNotTree();
    }
}
