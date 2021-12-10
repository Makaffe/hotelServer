package com.example.demo.service;

import com.example.demo.po.Order;
import com.example.demo.po.Room;

import java.text.ParseException;
import java.util.List;

public interface OrderService {

    void add (Order order);

    List findAll();

    String delete(Long Id);

    String update(Long Id, Order order);

    Room findById(Long Id);
}
