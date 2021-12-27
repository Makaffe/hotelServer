package com.example.demo.controller;

import com.example.demo.po.Order;
import com.example.demo.po.User;
import com.example.demo.service.OrderService;
import com.example.demo.vo.OrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api(value = "订单实体类",tags = {"订单管理"})
@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("新增订单")
    @PostMapping("/startOrder")

    public Order add(@RequestBody Order order) throws ParseException {

        orderService.add(order);
        return order;
    }
    @ApiOperation("结束订单")
    @PostMapping("/endOrder/{id}")
    public Order end(@PathVariable("id") Long Id) throws ParseException {

        orderService.end(Id);
        Order o = orderService.findById(Id);

        return o;
    }

    @ApiOperation("查询所有订单")
    @GetMapping("/findAll")
    public List findAll(){
        return orderService.findAll();
    }


    @ApiOperation("根据条件查询所有订单")
    @PostMapping("/findByQuery")
    public List search(@RequestBody OrderQuery order) {

        return orderService.listOrder(order);
    }


}
