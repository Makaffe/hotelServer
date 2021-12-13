package com.example.demo.controller;

import com.example.demo.Dao.RecommendDao;
import com.example.demo.po.Recommend;
import com.example.demo.vo.OrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("订单实体类")
@RestController
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendDao recommendDao;

    @ApiOperation("查看当前用户的推荐房间" )
    @GetMapping("/findByUser/{id}")
    public List findAllByUser(@PathVariable("id") Long user_Id){
        return recommendDao.findByUser(user_Id);
    }

    @ApiOperation("用户删除自身的推荐信息")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long Id){
        Recommend r = recommendDao.findById(Id).get();
        recommendDao.delete(r);
        return "删除推荐成功";
    }

}
