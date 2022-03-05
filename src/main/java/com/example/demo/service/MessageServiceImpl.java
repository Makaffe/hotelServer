package com.example.demo.service;

import com.example.demo.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 76961
 */

@Transactional
@Service
public class MessageServiceImpl implements MessageService {
  @Autowired
  private RedisTemplate redisTemplate;
  String key = "MessageList_";

  @Override
  public List<Message> findAll() {
    ValueOperations<String,List<Message>> operations = redisTemplate.opsForValue();
    List<Message> messageList = new ArrayList<>();
    messageList = (List<Message>) operations.get(key);
    return messageList;
  }

  @Override
  public Message add(Message message) {
    ValueOperations<String,List<Message>> operations = redisTemplate.opsForValue();
    List<Message> messageList = new ArrayList<>();
    messageList.add(message);
    operations.set(key,(List<Message>) messageList,5, TimeUnit.DAYS);
    System.out.println("存入redis");
    return message;
  }

  @Override
  public Message confirm(Message message) {
    ValueOperations<String,List<Message>> operations = redisTemplate.opsForValue();
    List<Message> messageList = new ArrayList<>();

    boolean hasKey = redisTemplate.hasKey(key);
    if(hasKey){
      messageList =  (List<Message>) operations.get(key);
      messageList.remove(message);
      redisTemplate.delete(hasKey);
      operations.set(key,(List<Message>) messageList,5, TimeUnit.DAYS);
    }


    return message;
  }
}
