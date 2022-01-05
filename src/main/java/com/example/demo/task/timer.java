package com.example.demo.task;

import com.example.demo.po.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class timer {
    @Autowired
    private OrderService orderService;

    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void scheduled() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        List<Order> orderlist = orderService.findAll();
        for(Order o : orderlist ){
            if(compareDate(o.getEndDate(), dateFormat.format(date))){
                this.orderService.end(o.getId());
            }
        }
    }

    public boolean compareDate(String DATE1,String DATE2) {
        //初始返回值
        boolean f=false;
        try {
            // 之前把月份小写了，导致错误 DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            //dt1在dt2后
            if (dt1.getTime() <= dt2.getTime()) {
                f=true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return f;
    }

}
