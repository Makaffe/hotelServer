package com.example.demo.po;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author 76961
 */
@Entity
@Table(name="t_message")
public class Message implements Serializable {

  @ApiModelProperty(value = "用户Id",required = false,dataType = "Long")
  private Long user_Id;
  @ApiModelProperty(value = "消息内容",required = false,dataType = "String")
  private String content;


  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @ApiModelProperty(value = "消息状态",required = false,dataType = "String")
  private String status;

  @ApiModelProperty(value = "删除状态",required = false,dataType = "String")
  private boolean delFlag;


  public Long getUser_Id() {
    return user_Id;
  }

  public void setUser_Id(Long user_Id) {
    this.user_Id = user_Id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public boolean isDelFlag() {
    return delFlag;
  }

  public void setDelFlag(boolean delFlag) {
    this.delFlag = delFlag;
  }
}
