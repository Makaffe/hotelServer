package com.example.demo.service;

import com.example.demo.po.User;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    void add(User user);

    List findAll();

    void delete(Long Id);

    String update(Long Id,User user);


}
