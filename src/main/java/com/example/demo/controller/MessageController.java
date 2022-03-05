package com.example.demo.controller;

import com.example.demo.po.Message;
import com.example.demo.po.Order;
import com.example.demo.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api(value = "消息实体类",tags = {"消息管理"})
@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {
  @Autowired
  private MessageService messageService;

  @ApiOperation("查询所有消息")
  @GetMapping("/findAll")
  public List findAll(){
    return messageService.findAll();
  }

  @ApiOperation("新增消息")
  @PostMapping("/addMessage")

  public Message add(@RequestBody Message message) {
    messageService.add(message);
    return message;
  }
  @ApiOperation("确认收到消息")
  @PostMapping("/confirm")

  public Message confirm(@RequestBody Message message) {
    messageService.confirm(message);
    return message;
  }

}
