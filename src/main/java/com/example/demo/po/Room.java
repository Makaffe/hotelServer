package com.example.demo.po;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="t_room")
public class Room {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;

    @ApiModelProperty(value = "房间名",required = false)
    private String roomName;
//    @NotNull(message = "所属大厅不能为空")
    @ApiModelProperty(value = "所属大厅名",required = true)
    private String hallName;
//    @NotNull(message = "房间状态不能为空")
    @ApiModelProperty(value = "房间可住状态",required = true,example = "true")
    private boolean status;

    @ApiModelProperty(value = "父节点Id",required = false,example="1")
    private Long parent_Id;

    @ApiModelProperty(value = "房间图片",required = false)
    private String image;

//    @NotBlank(message = "描述不能为空")
    @ApiModelProperty(value = "房间描述",required = true)
    private String description;

    @ApiModelProperty(value = "房间价格",required = false)
    private String price;

    @ApiModelProperty(value = "删除字段", required = false)
    private String del_flag;

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    @Transient
    private List<Room> children =new ArrayList<Room>();


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public Long getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(Long parent_Id) {
        this.parent_Id = parent_Id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public List<Room> getChildren() {
        return children;
    }

    public void setChildren(List<Room> children) {
        this.children = children;
    }

    /**
     * 下方为多对多的关系
     */
}
