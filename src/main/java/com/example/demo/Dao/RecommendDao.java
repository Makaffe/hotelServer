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

    @Query(value = "select c.id,u.id 用户id,r.id 房间id,r.description,r.hall_name,r.image,r.price,r.room_name,r.status from t_recommend c inner join t_room r on c.room_id = r.id inner join t_user u on c.user_id = u.id GROUP BY c.id ;" ,nativeQuery = true)
    List findRecommend();
}
