package com.example.demo.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name="t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ApiModelProperty(value = "父节点Id",required = false,example="1")
    private Long parent_Id;

    @ApiModelProperty(value = "评论内容",required = true)
    private String content;

    @ApiModelProperty(value = "订单Id",required = true)
    private Long order_Id;

    @ApiModelProperty(value = "用户Id",required = false)
    private Long user_Id;

    @ApiModelProperty(value = "房间Id",required = false)
    private Long room_Id;

    @ApiModelProperty(value = "好评星数",required = true)
    private double startCount;

    @Transient
    private List<Comment> children =new ArrayList<Comment>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(Long parent_Id) {
        this.parent_Id = parent_Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
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

    public double getStartCount() {
        return startCount;
    }

    public void setStartCount(double startCount) {
        this.startCount = startCount;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
    }
}
