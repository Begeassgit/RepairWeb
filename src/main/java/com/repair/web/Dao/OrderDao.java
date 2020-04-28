package com.repair.web.Dao;

import com.repair.web.Entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderDao {
    @Select("SELECT * FROM maintenance_db.order_t WHERE (order_company=#{order_company})")
    List<Order>getOrder(String order_company);

    @Insert("INSERT INTO maintenance_db.order_t(order_id,order_time,order_address,order_deviceName,order_deviceType,order_info,order_status,order_company)" +
            "VALUES(?,?,?,?,?,?,?,?")
    int addOrder(Order order);

    @Update("UPDATE maintenance_db.order_t SET order_status=#{order_status} WHERE (order_id=#{order_id})")
    int statusOrder(String order_status,String order_id);
}
