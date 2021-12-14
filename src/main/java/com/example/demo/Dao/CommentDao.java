package com.example.demo.Dao;

import com.example.demo.po.Comment;
import com.example.demo.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.user_Id = ?1")
    List<Comment> findByUser_Id(Long user_id);

    @Query("select c from Comment c where c.room_Id = ?1")
    List<Comment> findByRoom_Id(Long room_Id);

    @Query("select c from Comment c where c.order_Id = ?1")
    List<Comment> findByOrder_Id(Long order_Id);
}
