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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "评论实体类",tags = {"评论管理"})
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("根据条件查询所有订单")
    @PostMapping("/search")
    public List<Comment> search(@ApiParam("查询条件") CommentQuery commentQuery) {
        return commentService.findByQuery(commentQuery);
    }

    @ApiOperation("新增评论")
    @PostMapping("/add")
    public String add(@ApiParam Comment comment){
        return commentService.add(comment);
    }
}
