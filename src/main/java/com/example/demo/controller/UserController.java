package com.example.demo.controller;

import com.example.demo.Dao.UserDao;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.OrderQuery;
import com.example.demo.vo.RoleQuery;
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
    public User add(@RequestBody User user){
        userService.add(user);
        return user;
    }
    @ApiOperation("查询所有用户")
    @GetMapping("/all")
    public List findAll(){
        return userService.findAll();
    }
    @ApiOperation("删除用户")
    @PostMapping("/delete/{id}")
    public User delete(@PathVariable("id") Long Id){
        User user = userDao.findById(Id).get();

        userService.delete(Id);
        return user;
    }
    @ApiOperation("更新用户")
    @PostMapping("/update/{id}")
    public User update(@PathVariable("id") Long Id,@RequestBody User user){

        return  userService.update(Id,user);
    }
    @ApiOperation("登录验证")
    @PostMapping("/login")
    public User login(@RequestBody User user, HttpSession session){
        String userName = user.getUsername();
        String pwd = user.getPassword();
        String userType = user.getUserType();
        user = userDao.findByUserNameAndPwd(userName,pwd,userType);
        String str = "";
        if(user!=null){
            session.setAttribute("userLogin",user);
            return user;
        }else{
            return null;
        }
    }

    @ApiOperation("根据条件查询用户")
    @PostMapping("/findByQuery")
    public List search(@RequestBody RoleQuery query) {

        return userService.findByQuery(query);
    }



}
