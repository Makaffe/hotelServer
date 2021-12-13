package com.example.demo.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name="t_recommend")
public class Recommend {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Id;

    private Long user_Id;

    private Long room_Id;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public Long getRoom_Id() {
        return room_Id;
    }

    public void setRoom_Id(Long room_Id) {
        this.room_Id = room_Id;
    }
}
