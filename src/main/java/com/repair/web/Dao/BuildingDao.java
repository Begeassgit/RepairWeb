package com.repair.web.Dao;/*
    Author:Yin
*/

import com.repair.web.Entity.Building;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuildingDao {
    @Select("SELECT building_id,building_name,building_status,building_info,building_department,building_company " +
            "FROM building_t WHERE building_company=#{company}")
    List<Building>getAllBuilding(String company);
}
