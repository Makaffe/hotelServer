package com.example.demo.Dao;

import com.example.demo.po.Order;
import com.example.demo.po.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    @Modifying
    @Query(value = "update Order o set o.status = ?1 where o.id = ?2")
    void updateStatus(boolean status,Long id);

    @Modifying
    @Query(value = "update Order o set o.status = ?1,o.endDate = ?2,o.totalPrice = ?3,o.modifyTime = ?4 where o.id = ?5")
    void endOrder(boolean status, String endDate, String price, Date modifyTime, Long id);

//    @Modifying  查询条件
    @Query("select o from Order o where o.user_Id = ?1")
    List<Order> findByUser_Id(Long user_id);

    @Query("select o from Order o where o.user_Id=?1 and o.room_Id=?2 and o.status=?3")
    List<Order> findAllByQuery(Long user_Id,Long room_Id,Boolean status);

    @Query("select o from Order o where o.user_Id=?1 and o.room_Id=?2")
    List<Order> findByUser_IdAndRoom_Id(Long user_Id,Long room_Id);

    @Query("select o from Order o where o.user_Id=?1 and o.status=?2")
    List<Order> findByUser_idAndStatus(Long user_Id,Boolean status);

    @Query("select o from Order o where o.room_Id=?1")
    List<Order> findByRoom_id(Long room_Id);

    @Query("select o from Order o where o.room_Id=?1 and o.status=?2")
    List<Order> findByRoom_idAndStatus(Long room_Id,Boolean status);

    @Query("select o from Order o where o.status=?1")
    List<Order> findByStatus(Boolean status);
}
