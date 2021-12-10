package com.example.demo.po;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="t_user")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;
    @ApiModelProperty(value = "账号",required = false)
    private String username;
    @ApiModelProperty(value = "密码",required = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
