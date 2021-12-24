package com.example.demo.controller;

import com.example.demo.Dao.RecommendDao;
import com.example.demo.po.Recommend;
import com.example.demo.po.Room;
import com.example.demo.service.RecommendService;
import com.example.demo.vo.OrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "推荐实体类",tags = {"收藏管理"})
@RestController
@CrossOrigin
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    private RecommendDao recommendDao;

    @Autowired
    private RecommendService recommendService;

    @ApiOperation("查看当前用户的推荐房间" )
    @GetMapping("/findByUser/{id}")
    public List findAllByUser(@PathVariable("id") Long user_Id){
        return recommendDao.findByUser(user_Id);
    }

    @ApiOperation("用户删除自身的推荐信息")
    @DeleteMapping("/delete/{id}")
    public Recommend delete(@PathVariable("id") Long Id){
        Recommend r = recommendDao.findById(Id).get();
        recommendDao.delete(r);
        return r;
    }

    @ApiOperation("用户收藏房间")
    @PostMapping("/add")
    public Recommend add(@RequestBody Recommend recommend){
        Recommend recommend1 = recommend;
        recommendService.add(recommend);
        return recommend1;
    }

    @ApiOperation("查询所有收藏")
    @GetMapping("/findRecommend")
    public List findAll(){
        return recommendDao.findRecommend();
    }


}
