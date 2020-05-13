package com.repair.web.Dao;

import com.repair.web.Entity.TakeList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TakeListDao {
    @Select("SELECT * FROM maintenance_db.take_list_t WHERE (take_list_company=#{take_list_company})")
    List<TakeList> getTakeList(String take_list_company);

    @Insert("INSERT INTO maintenance_db.take_list_t(take_list_list_id,take_list_id,take_list_name,take_list_department,take_list_time,take_list_company)" +
            "VALUES (#{take_list_list_id},#{take_list_id},#{take_list_name},#{take_list_department},#{take_list_time},#{take_list_company}")
    int addTakeList(TakeList takeList);
}
