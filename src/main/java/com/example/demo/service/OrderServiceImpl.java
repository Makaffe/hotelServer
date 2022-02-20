package com.example.demo.service;

import com.example.demo.Dao.OrderDao;
import com.example.demo.Dao.RoomDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.po.Order;
import com.example.demo.po.Room;
import com.example.demo.po.User;
import com.example.demo.vo.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private UserDao userDao;

    @Override
    public String add(Order order) throws ParseException {
        if(order.getId()==null){
            order.setCreateTime(new Date());
            order.setModifyTime(new Date());

        }
        Room r = roomDao.getById(order.getRoom_Id());
        User u = userDao.getById(order.getUser_Id());
        //判断房间是否可用
        if(r.isStatus()) {
            if (r != null && r.getParent_Id() != null && u != null) {
                //设置订单状态为进行中
                order.setStatus(true);
                //计算用户预定次数
                double price;
                if(u.getBookingTime()<3){
                    price = Integer.parseInt(r.getPrice())*0.8;
                }else{
                    price = Integer.parseInt(r.getPrice());
                }
                //自动计算总价
                order.setTotalPrice((daysBetween(order.getStartDate(),order.getEndDate())*price)+"");
                order.setCommentStatus(true);
                orderDao.save(order);
                //设置房间状态为不可用
                roomDao.updateStatus(false, r.getId());
                //设置用户预定次数+1
                userDao.updateBookingTime(u.getId());
                if(orderDao.isExist(u.getId(),r.getId())==null) {
                    //推荐表不存在相应的数据才添加进数据库中
                    orderDao.addRecommend(u.getId(), r.getId());
                }
                return "新建订单成功";
            } else {
                return "请检查房间和用户ID";
            }
        }else{
            return "该房间已经有人了";
        }
    }

    @Override
    public String end(Long Id) throws ParseException {
        Order o = orderDao.getById(Id);
        if(o!=null||!o.isStatus()){
            Room r = roomDao.getById(o.getRoom_Id());
            Date date = new Date();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String endDate = sdf.format(date);
            int price = Integer.parseInt(r.getPrice());
            if(this.daysBetween(o.getEndDate(),endDate)>0){
                String totalPrice = (daysBetween(o.getStartDate(),o.getEndDate())*price)+"";
                orderDao.endOrder(false,o.getEndDate(),totalPrice,new Date(),Id);
            }else {
                String totalPrice = (daysBetween(o.getStartDate(), endDate) * price) + "";
                orderDao.endOrder(false, endDate, totalPrice, new Date(), Id);
            }
            roomDao.updateStatus(true, r.getId());
        }else{
            return "订单已经结束或无此订单ID";
        }

        return "订单已经结束";
    }


    @Override
    public List<Order> listOrder(OrderQuery order) {
        if(order.getUser_Id()!=null&&order.getRoom_Id()==null&&order.getStatus()==null){
            return orderDao.findByUser_Id(order.getUser_Id());
        }else if (order.getUser_Id()!=null&&order.getRoom_Id()!=null&&order.getStatus()==null){
            return orderDao.findByUser_IdAndRoom_Id(order.getUser_Id(),order.getRoom_Id());
        }else if (order.getUser_Id()!=null&&order.getRoom_Id()==null&&order.getStatus()!=null){
            return orderDao.findByUser_idAndStatus(order.getUser_Id(),order.getStatus());
        }else if (order.getUser_Id()==null&&order.getRoom_Id()!=null&&order.getStatus()==null){
            return orderDao.findByRoom_id(order.getRoom_Id());
        }else if (order.getUser_Id()==null&&order.getRoom_Id()!=null&&order.getStatus()!=null){
            return orderDao.findByRoom_idAndStatus(order.getRoom_Id(),order.getStatus());
        }else if (order.getUser_Id()==null&&order.getRoom_Id()==null&&order.getStatus()!=null){
            return orderDao.findByStatus(order.getStatus());
        }else if (order.getUser_Id()!=null&&order.getRoom_Id()!=null&&order.getStatus()!=null) {
            return orderDao.findAllByQuery(order.getUser_Id(), order.getRoom_Id(), order.getStatus());
        }else{
            return orderDao.findAll();
        }
    }


    @Override
    public List findAll() {
        return orderDao.findAllByDesc();
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
    public Order findById(Long Id) {
        Order o = orderDao.getById(Id);
        return o;
    }




    private int daysBetween(String startdate,String enddate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date smdate = sdf.parse(startdate);
        Date bdate = sdf.parse(enddate);
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


    //    @Override  未实现
//    public Page<Order> listOrder(Pageable pageable, OrderQuery order) {
//        return orderDao.findAll(new Specification<Order>() {
//            @Override
//            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                List<Predicate> predicates = new ArrayList<>();
//
//                if (order.getRoom_Id() != null) {
//                    predicates.add(criteriaBuilder.equal(root.<Room>get("room_Id").get("id"), order.getRoom_Id()));
//                }
//                if (order.getUser_Id() != null) {
//                    predicates.add(criteriaBuilder.equal(root.<User>get("user_Id").get("id"), order.getUser_Id()));
//                }
//                if (order.getStatus() != null) {
//                    predicates.add(criteriaBuilder.equal(root.<Boolean>get("status"), order.getStatus()));
//                }
//                query.where(predicates.toArray(new Predicate[predicates.size()]));
//                return null;
//            }
//        }, pageable);
//    }
}
