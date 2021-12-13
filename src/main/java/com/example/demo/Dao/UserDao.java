package com.example.demo.Dao;

import com.example.demo.po.User;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("select s from User s where s.username = ?1 and s.password = ?2")
    User findByUserNameAndPwd(String userName,String pwd);

    @Modifying
    @Query(value = "update User u set u.bookingTime = u.bookingTime+1 where u.Id = ?1")
    void updateBookingTime(Long id);
}
