package com.example.demo.service;

import com.example.demo.po.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Autowired
    private OrderService orderService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("通过实现ApplicationRunner接口，在spring boot项目启动后打印参数");
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
