package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.po.User;
import javassist.NotFoundException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao ;


    @Override
    public void add(User user) {
        user.setBookingTime(0);
        userDao.save(user);
    }

    @Override
    public List findAll(){

       return userDao.findAll();
    }

    @Override
    public void delete(Long Id) {
        userDao.delete(userDao.getById(Id));
    }

    @Override
    public String update(Long Id, User user){
       User u = userDao.findById(Id).get();
       if(u==null){
           return "不存在该类型";
       }
        BeanUtils.copyProperties(user,u);
        userDao.save(u);
       return "更新成功";
    }



}
