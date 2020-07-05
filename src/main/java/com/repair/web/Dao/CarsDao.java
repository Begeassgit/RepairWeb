package com.repair.web.Dao;/*
    Author:Yin
*/

import com.repair.web.Entity.Cars;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CarsDao {
    @Select("SELECT cars_id,cars_name,cars_brand,cars_status,cars_department,cars_company FROM cars_t where cars_company=#{cars_company}")
    List<Cars> getAllCar(String cars_company);

    @Delete("DELETE FROM cars_t WHERE cars_id=#{cars_id} AND cars_company=#{cars_company}")
    int delCar(String cars_id,String cars_company);

    @Update("UPDATE cars_t set cars_department=#{cars_department} WHERE cars_id=#{cars_id} AND cars_company=#{cars_company}")
    int borrowOut(String cars_id,String cars_department,String cars_company);

    @Insert("INSERT INTO cars_t(cars_id,cars_name,cars_brand,cars_status,cars_department,cars_company) VALUES " +
            "(#{cars_id},#{cars_name},#{cars_brand},#{cars_status},#{cars_department},#{cars_company})")
    int addCar(Cars cars);

}
