package com.example.demo.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="t_order")
//以下注释    在实体类中 发现有字段为null，在转化成json的时候，fasterxml.jackson将对象转换为json报错
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private boolean commentStatus;

    private String totalPrice;

    @ApiModelProperty(value = "开始时间",required = false,example = "2021-01-01")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String startDate;

    @ApiModelProperty(value = "结束时间",required = false,example = "2021-01-01")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String endDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;
    @ApiModelProperty(value = "订单状态(1为进行中，0为已结束)")
    private boolean status;
    @ApiModelProperty(value = "房间ID",required = true)
    private Long room_Id;

    @ApiModelProperty(value = "用户ID",required = true)
    private Long user_Id;

    @ApiModelProperty(value = "同居住客姓名，姓名和身份证使用逗号隔开", required = false)
    private String temporaryName;

    @ApiModelProperty(value = "同居住客身份证，姓名和身份证使用逗号隔开", required = false)
    private String temporaryID;



    public Long getRoom_Id() {
        return room_Id;
    }

    public void setRoom_Id(Long room_Id) {
        this.room_Id = room_Id;
    }

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getTemporaryName() {
        return temporaryName;
    }

    public void setTemporaryName(String temporaryName) {
        this.temporaryName = temporaryName;
    }

    public String getTemporaryID() {
        return temporaryID;
    }

    public void setTemporaryID(String temporaryID) {
        this.temporaryID = temporaryID;
    }
}
