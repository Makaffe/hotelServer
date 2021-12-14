package com.example.demo.Dao;

import com.example.demo.po.Recommend;
import com.example.demo.po.Room;
import com.example.demo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecommendDao extends JpaRepository<Recommend, Long> {
    @Modifying
    @Query("select r from Recommend r where r.user_Id = ?1")
    List<Recommend> findByUser(Long user_Id);

    @Query("select r from Recommend r where r.user_Id = ?1 and r.room_Id = ?2")
    Recommend findByUserAndRoom(Long user_Id,Long room_Id);

}
