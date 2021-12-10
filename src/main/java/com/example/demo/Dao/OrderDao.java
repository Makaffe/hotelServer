package com.example.demo.Dao;

import com.example.demo.po.Order;
import com.example.demo.po.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {

}
