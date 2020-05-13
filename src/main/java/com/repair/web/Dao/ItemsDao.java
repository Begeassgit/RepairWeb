package com.repair.web.Dao;

import com.repair.web.Entity.Items;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemsDao {
    @Select("SELECT * FROM maintenance_db.items_t WHERE (items_company=#{items_company} AND items_department=#{items_department})")
    List<Items> getMyItems(String items_company, String items_department);

    @Select("SELECT * FROM maintenance_db.items_t WHERE (items_company=#{items_company})")
    List<Items> itemsForBase(String items_company);

    @Delete("DELETE FROM maintenance_db.items_t WHERE(items_id=#{items_id})")
    int delOne(String items_id);

    @Insert("INSERT INTO maintenance_db.items_t(items_id,items_name,items_type,items_brand,items_count,items_info," +
            "items_department,items_company) VALUES(#{items_id},#{items_name},#{items_type},#{items_brand},#{items_count},#{items_info},"+
            "#{items_department},#{items_company})")
    int addItems(Items items);

    @Update("UPDATE maintenance_db.items_t SET（items_department=#{items_department}) WHERE (items_id=#{items_id})")
    int updateBorrow(String items_id,String items_department);

    @Select("SELECT * FROM maintenance_db.items_t WHERE(items_id=#{items_id})")
    Items getItemsInfo(String items_id);
}
