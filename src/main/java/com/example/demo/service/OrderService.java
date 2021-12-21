package com.example.demo.service;

import com.example.demo.po.Order;
import com.example.demo.po.Room;
import com.example.demo.vo.OrderQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface OrderService {

    String add (Order order) throws ParseException;

    String end (Long Id) throws ParseException;

    List<Order> listOrder(OrderQuery order);

    List findAll();

    String delete(Long Id);

    String update(Long Id, Order order);

    Order findById(Long Id);
}
