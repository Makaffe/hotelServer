package com.example.demo.service;

import com.example.demo.Dao.RoomDao;
import com.example.demo.Dao.TotalDao;
import com.example.demo.po.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class TotalServiceImpl implements TotalService{
    @Autowired
    private TotalDao totalDao;

    @Override
    public List findMoneyByRoom() {
        List result = new ArrayList();
        List allList = totalDao.findMoneyByRoom();

        return allList;
    }

    @Override
    public List findLikeByRoom() {
        List allList = totalDao.findLikeByRoom();
        return allList;
    }
}
