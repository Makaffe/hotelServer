package com.example.demo.controller;

import com.example.demo.Dao.TotalDao;
import com.example.demo.service.TotalService;
import com.example.demo.vo.OrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="统计实体类",tags = {"统计数据"})
@RestController
@CrossOrigin
@RequestMapping("/total")
public class TotalController {
    @Autowired
    private TotalService totalService;

    @ApiOperation("查询每个房间的统计收入")
    @GetMapping("/findMoneyByRoom")
    public List findMoneyByRoom() {

        return totalService.findMoneyByRoom();
    }

    @ApiOperation("查询每个房间的好评数")
    @GetMapping("/findLikeByRoom")
    public List findLikeByRoom() {

        return totalService.findLikeByRoom();
    }


}
