package com.example.demo.Dao;

import com.example.demo.po.User;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("select s from User s where s.username = ?1 and s.password = ?2")
    public User findByUserNameAndPwd(String userName,String pwd);
}
