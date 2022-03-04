package com.example.demo.service;

import com.example.demo.Dao.UserDao;
import com.example.demo.po.User;
import com.example.demo.vo.RoleQuery;
import javassist.NotFoundException;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao ;


    @Override
    public void add(User user) {
        if(user.getUserType()==null){
            user.setUserType("User");

        }
        user.setToken(String.valueOf(new Date().getTime()));
        user.setBookingTime(0);
        userDao.save(user);
    }

    @Override
    public List findAll(){

       return userDao.findAll();
    }

    @Override
    public void delete(Long Id) {
        userDao.delete(userDao.findById(Id).get());
    }

    @Override
    public User update(Long Id, User user){
       User u = userDao.findById(Id).get();
       if(u==null){
           return null;
       }
        BeanUtils.copyProperties(user,u);
        userDao.save(u);
       return user;
    }

    @Override
    public List<User> findByQuery(RoleQuery query){
        return userDao.findByQuery(query.getName(),query.getPhone(),query.getRole());
    }


//    private String getNewToken(Long userId){
//        String timeStr = new Date().toString();
//        String token = timeStr + userId;
//        return token;
//    }



}
