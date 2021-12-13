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
    @ApiModelProperty(value = "账号",required = true)
    private String username;
    @ApiModelProperty(value = "密码",required = true)
    private String password;

    @ApiModelProperty(value = "身份证号码",required = true)
    private String identity ;
    @ApiModelProperty(value = "姓名",required = true)
    private String name;
    @ApiModelProperty(value = "手机号",required = true)
    private String phone;

    @ApiModelProperty(value="预定次数",required = false)
    private Integer bookingTime;


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


    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Integer bookingTime) {
        this.bookingTime = bookingTime;
    }

    /**
     * 下方为多对多的关系映射
     */
}
