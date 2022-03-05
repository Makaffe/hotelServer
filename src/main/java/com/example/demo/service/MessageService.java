package com.example.demo.service;

import com.example.demo.po.Message;

import java.util.List;

/**
 * @author 76961
 */
public interface MessageService {
  List<Message> findAll();

  Message add(Message message);

  Message confirm(Message message);
}
