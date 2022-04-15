package com.example.demo.Dao;

import com.example.demo.po.Room;
import com.example.demo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface RoomDao extends JpaRepository<Room, Long> {
    @Modifying
    @Query(value = "update Room r set r.status = ?1 where r.Id = ?2")
    void updateStatus(boolean status,Long id);

    @Modifying
    @Transactional
    @Query(value = "update Room r set r.del_flag = '1' where r.Id = ?1")
    void delRoom(Long id);

}
