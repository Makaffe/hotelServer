package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;

public class OrderQuery {
    @ApiModelProperty(value = "用户Id",required = false,dataType = "Long")
    private Long user_Id;
    @ApiModelProperty(value = "房间Id",required = false,dataType = "Long")
    private Long room_Id;
    @ApiModelProperty(value = "订单状态",required = false,dataType = "Boolean")
    private Boolean status;

    public OrderQuery(Long user_Id, Long room_Id, Boolean status) {
        this.user_Id = user_Id;
        this.room_Id = room_Id;
        this.status = status;
    }

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
