package com.example.demo.service;

import com.example.demo.po.Room;
import com.example.demo.po.User;

import java.util.List;

public interface RoomService {
    void add (Room room);

    List findAll();

    String delete(Long Id);

    String update(Long Id, Room room);

    Room findById(Long Id);

}
