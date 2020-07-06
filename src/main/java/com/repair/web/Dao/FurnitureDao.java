package com.repair.web.Dao;/*
    Author:Yin
*/

import com.repair.web.Entity.Furniture;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FurnitureDao {
    @Select("SELECT furniture_id,furniture_name,furniture_type,furniture_brand,furniture_count,furniture_status,furniture_department,furniture_company FROM " +
            "furniture_t WHERE furniture_company=#{company}")
    List<Furniture> getAllFurniture(String company);
}
