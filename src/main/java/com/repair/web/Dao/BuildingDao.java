package com.repair.web.Dao;/*
    Author:Yin
*/

import com.repair.web.Entity.Building;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuildingDao {
    @Select("SELECT building_id,building_name,building_status,building_info,building_department,building_company " +
            "FROM building_t WHERE building_company=#{company}")
    List<Building>getAllBuilding(String company);

    @Delete("DELETE FROM building_t WHERE building_company=#{company} AND building_id=#{id}")
    int delOne(String id,String company);

    @Insert("INSERT INTO building_t(building_id,building_name,building_status,building_info,building_department,building_company)" +
            " VALUES(#{building_id},#{building_name},#{building_status},#{building_info},#{building_department},#{building_company})")
    int addOneBuilding(Building building);
}
