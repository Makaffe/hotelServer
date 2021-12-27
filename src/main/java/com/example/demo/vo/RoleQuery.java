package com.example.demo.vo;

import io.swagger.annotations.ApiModelProperty;

public class RoleQuery {
    public RoleQuery() {
    }


    @ApiModelProperty(value = "姓名",required = false,dataType = "String")
    private String name;
    @ApiModelProperty(value = "手机号",required = false,dataType = "String")
    private String phone;
    @ApiModelProperty(value = "角色身份",required = false,dataType = "String")
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
