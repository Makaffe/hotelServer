package com.example.demo.service;

import com.example.demo.Dao.RecommendDao;
import com.example.demo.po.Recommend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RecommendServiceImpl implements RecommendService{
    @Autowired
    private RecommendDao recommendDao;

    @Override
    public String add(Recommend recommend) {
        Recommend r = recommendDao.findByUserAndRoom(recommend.getUser_Id(),recommend.getRoom_Id());
        if(r!=null){
            return "已经添加";
        }else{
            recommendDao.save(recommend);
            return "收藏成功";
        }
    }
}
