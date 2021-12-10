package com.example.demo.service;

import com.example.demo.Dao.OrderDao;
import com.example.demo.Dao.RoomDao;
import com.example.demo.po.Order;
import com.example.demo.po.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Transactional
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RoomDao roomDao;

    @Override
    public void add(Order order) {
        if(order.getId()==null){
            order.setCreateTime(new Date());
            order.setModifyTime(new Date());

            roomDao.updateStatus(false,order.getRoom().getId());

        }
        orderDao.save(order);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String delete(Long Id) {
        return null;
    }

    @Override
    public String update(Long Id, Order order) {
        return null;
    }

    @Override
    public Room findById(Long Id) {
        return null;
    }



    private int daysBetween(Date smdate,Date bdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}
