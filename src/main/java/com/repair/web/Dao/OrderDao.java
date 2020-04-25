package com.repair.web.Dao;

import com.repair.web.Entity.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    @Select("SELECT * FROM maintenance_db.order_t WHERE (order_company=#{order_company})")
    List<Order>getOrder(String order_company);

}
