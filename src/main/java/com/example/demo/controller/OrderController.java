package com.example.demo.controller;

import com.example.demo.po.Order;
import com.example.demo.po.User;
import com.example.demo.service.OrderService;
import com.example.demo.vo.OrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api(value = "订单实体类",tags = {"订单管理"})
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ApiOperation("新增订单")
    @PostMapping("/startOrder")

    public String add(@RequestBody Order order) throws ParseException {

        return orderService.add(order);
    }
    @ApiOperation("结束订单")
    @PostMapping("/endOrder/{id}")
    public String end(@PathVariable("id") Long Id) throws ParseException {

        return orderService.end(Id);
    }

    @ApiOperation("查询所有订单")
    @GetMapping("/findAll")
    public List findAll(){
        return orderService.findAll();
    }
    @ApiOperation("根据条件查询所有订单")
    @PostMapping("/findByQuery/search")
    public List search(@ApiParam("查询条件") OrderQuery order) {

        return orderService.listOrder(order);
    }


}
