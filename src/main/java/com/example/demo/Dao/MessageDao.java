package com.example.demo.Dao;

import com.example.demo.po.Comment;
import com.example.demo.po.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageDao extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.status = ?1")
    List<Message> findByStatus(String status);
}
