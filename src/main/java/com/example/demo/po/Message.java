package com.example.demo.po;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @author 76961
 */

public class Message implements Serializable {

  @ApiModelProperty(value = "用户Id",required = false,dataType = "Long")
  private Long user_Id;
  @ApiModelProperty(value = "房间Id",required = false,dataType = "Long")
  private Long room_Id;
  @ApiModelProperty(value = "消息内容",required = false,dataType = "String")
  private String content;


  public Long getUser_Id() {
    return user_Id;
  }

  public void setUser_Id(Long user_Id) {
    this.user_Id = user_Id;
  }

  public Long getRoom_Id() {
    return room_Id;
  }

  public void setRoom_Id(Long room_Id) {
    this.room_Id = room_Id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
