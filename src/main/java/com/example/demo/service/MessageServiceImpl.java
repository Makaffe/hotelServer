package com.example.demo.service;

import com.example.demo.Dao.MessageDao;
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

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> findAll(String status) {
        if(status != null && status!=""){
            return messageDao.findByStatus(status);
        }else{
            return messageDao.findAll();
        }
    }

    @Override
    public Message add(Message message) {
        message.setStatus("Waiting");
        message.setDelFlag(false);
        this.messageDao.save(message);
        return message;

    }

    @Override
    public Message confirm(Long id) {
        Message message = messageDao.findById(id).get();
        message.setStatus("Finish");
        return message;
    }

    @Override
    public Message delFlag(Long id) {
        Message message = messageDao.findById(id).get();
        message.setDelFlag(true);
        return message;
    }

    @Override
    public Message del(Long id) {
        Message message = messageDao.findById(id).get();
        messageDao.delete(message);
        return message;


    }
}
