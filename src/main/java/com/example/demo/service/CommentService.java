package com.example.demo.service;

import com.example.demo.po.Comment;
import com.example.demo.vo.CommentQuery;

import java.util.List;

public interface CommentService {
    String add(Comment comment);

    List<Comment> findByQuery(CommentQuery commentQuery);

    List<Comment> findAll();
}
