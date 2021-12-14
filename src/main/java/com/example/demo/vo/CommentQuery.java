package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;

public class CommentQuery {
    @ApiModelProperty(value = "用户Id",required = false,dataType = "Long")
    private Long user_Id;
    @ApiModelProperty(value = "房间Id",required = false,dataType = "Long")
    private Long room_Id;
    @ApiModelProperty(value = "订单Id",required = false,dataType = "Long")
    private Long order_Id;

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

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }
}
