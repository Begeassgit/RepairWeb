package com.repair.web.Service.FE;

import com.repair.web.Dao.DeviceDao;
import com.repair.web.Dao.OrderDao;
import com.repair.web.Entity.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    public final OrderDao orderDao;
    public final DeviceDao deviceDao;

    public OrderService(OrderDao orderDao,DeviceDao deviceDao) {
        this.orderDao = orderDao;
        this.deviceDao=deviceDao;
    }

    public List<Order> getOrder(String order_company,String order_department){
        return orderDao.getOrder(order_company,order_department);
    }

    public boolean addOrder(Order order){
        return orderDao.addOrder(order)>=1;
    }

    public boolean passOrder(String order_id,String order_department){
        String order_status="通过";
        return orderDao.statusOrder(order_status,order_id,order_department)>=1;
    }

    public boolean denyOrder(String order_id,String order_department){
        String order_status="退回";
        return orderDao.statusOrder(order_status,order_id,order_department)>=1;
    }

    public List<Integer> getCountInfo(String device_company,String order_department){
        List<Integer> list=new ArrayList<>();
        list.add(0,orderDao.getRepairSum(device_company,"处理中",order_department));
        list.add(1,orderDao.getSwitchSum(device_company,"需置换",order_department));
        return list;
    }

    public List<Order> getMyOrder(String company,String department,String submitUser){
        return orderDao.getMyOrder(company,department,submitUser);
    }

    public boolean delOneOrder(String user,String department,String company,String order_id){
        return orderDao.delOneOrder(company,department,user,order_id)>=1;
    }
}
