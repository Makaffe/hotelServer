package com.example.demo.controller;

import com.example.demo.Dao.UserDao;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Api(value="用户实体类",tags = {"用户管理"})
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @ApiOperation("注册用户")
    @PostMapping("/add")
    public User add(@ApiParam("用户") User user){
        userService.add(user);
        return user;
    }
    @ApiOperation("查询所有用户")
    @GetMapping("/all")
    public List findAll(){
        return userService.findAll();
    }
    @ApiOperation("删除用户")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long Id){
        userService.delete(Id);
        return "deleteSuccess";
    }
    @ApiOperation("更新用户")
    @PutMapping("/update/{id}")
    public String update(@PathVariable("id") Long Id,@ApiParam("用户") User user){

        return  userService.update(Id,user);
    }
    @ApiOperation("登录验证")
    @GetMapping("/login")
    public String login(@ApiParam("用户") User user, HttpSession session){
        String userName = user.getUsername();
        String pwd = user.getPassword();
        user = userDao.findByUserNameAndPwd(userName,pwd);
        String str = "";
        if(user!=null){
            session.setAttribute("userLogin",user);
            str = "验证成功，进入首页";
        }else{
            str = "验证失败，返回登录页面";
        }
        return str;
    }



}
