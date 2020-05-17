package com.repair.web.Dao;

import com.repair.web.Entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderDao {
    @Select("SELECT * FROM maintenance_db.order_t WHERE (order_company=#{order_company} AND order_department=#{order_department})")
    List<Order>getOrder(String order_company,String order_department);

    @Insert("INSERT INTO maintenance_db.order_t(order_submitUser,order_id,order_time,order_address,order_deviceName,order_deviceType,order_info,order_status,order_company)" +
            "VALUES(?,?,?,?,?,?,?,?,?")
    int addOrder(Order order);

    @Update("UPDATE maintenance_db.order_t SET order_status=#{order_status} WHERE (order_id=#{order_id} AND order_department=#{order_department})")
    int statusOrder(String order_status,String order_id,String order_department);

    @Select("SELECT COUNT(order_id) FROM maintenance_db.order_t WHERE (order_company=#{order_company} AND order_status=#{order_status} AND order_department=#{order_department})")
    int getRepairSum(String order_company,String order_status,String order_department);

    @Select("SELECT COUNT(order_id) FROM maintenance_db.order_t WHERE (order_company=#{order_company} AND order_status=#{order_status} AND order_department=#{order_department})")
    int getSwitchSum(String order_company,String order_status,String order_department);

    @Select("SELECT * FROM maintenance_db.order_t WHERE (order_company=#{order_company} AND order_department=#{order_department} AND order_submitUser=#{order_submitUser})")
    List<Order>getMyOrder(String order_company,String order_department,String order_submitUser);

    @Delete("DELETE FROM maintenance_db.order_t WHERE (order_company=#{order_company} AND order_department=#{order_department} AND order_submitUser=#{order_submitUser}" +
            "AND order_id=#{order_id})")
    int delOneOrder(String order_company,String order_department,String order_submitUser,String order_id);
}
