package com.example.demo.controller;

import com.example.demo.po.Order;
import com.example.demo.po.User;
import com.example.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Api("订单实体类")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("新增订单")
    @PostMapping("/add")
    public Order add(@ApiParam("订单") Order order){
        orderService.add(order);
        return order;
    }

}
