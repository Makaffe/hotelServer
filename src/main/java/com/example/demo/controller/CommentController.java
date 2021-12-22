package com.example.demo.controller;

import com.example.demo.po.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.service.OrderService;
import com.example.demo.vo.CommentQuery;
import com.example.demo.vo.OrderQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "评论实体类",tags = {"评论管理"})
@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("根据条件查询所有订单")
    @PostMapping("/search")
    public List<Comment> search(@RequestBody CommentQuery commentQuery) {
        return commentService.findByQuery(commentQuery);
    }

    @ApiOperation("新增评论")
    @PostMapping("/add")
    public Comment add(@RequestBody Comment comment){

        commentService.add(comment);
        return comment;
    }


    @ApiOperation("查询所有评论")
    @PostMapping("/searchAll")
    public List<Comment> findAll(){
        return commentService.findAll();
    }
}
