package com.example.demo.Dao;

import com.example.demo.po.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TotalDao extends JpaRepository<Order, Long> {
//    select * from t_order o inner join t_room r on o.room_Id = r.id;
//select room_name, sum(total_price) from t_order o inner join t_room r on o.room_Id = r.id
    @Query(value="select room_Id, hall_name, room_name, " +
            "sum(total_price) total_price from t_order o inner join t_room r on o.room_Id = r.id " +
            " GROUP BY room_Id ORDER BY sum(total_price) desc",nativeQuery = true)
    List findMoneyByRoom();

    @Query(value="select room_Id, hall_name, room_name, COUNT(start_count) 好评数 " +
            "from t_comment c inner join t_room r on c.room_id = r.id AND c.start_count>3 " +
            "GROUP BY room_Id ORDER BY COUNT(start_count) desc",nativeQuery = true)
    List findLikeByRoom();
}
