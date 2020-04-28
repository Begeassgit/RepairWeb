package com.repair.web.Service.FE;

import com.repair.web.Dao.OrderDao;
import com.repair.web.Entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getOrder(String order_company){
        return orderDao.getOrder(order_company);
    }

    public boolean addOrder(Order order){
        return orderDao.addOrder(order)>=1;
    }

    public boolean passOrder(String order_id){
        String order_status="通过";
        return orderDao.statusOrder(order_status,order_id)>=1;
    }

    public boolean denyOrder(String order_id){
        String order_status="退回";
        return orderDao.statusOrder(order_status,order_id)>=1;
    }
}
