package com.example.demo.Dao;

import com.example.demo.po.Room;
import com.example.demo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoomDao extends JpaRepository<Room, Long> {
    @Modifying
    @Query(value = "update Room r set r.status = ?1 where r.Id = ?2")
    void updateStatus(boolean status,Long id);

}
