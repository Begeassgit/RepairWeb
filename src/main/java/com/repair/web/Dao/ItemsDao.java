package com.repair.web.Dao;

import com.repair.web.Entity.Items;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemsDao {
    @Select("SELECT * FROM maintenance_db.items_t WHERE (items_company=#{items_company} AND items_department=#{items_department})")
    List<Items> getMyItems(String items_company, String items_department);

    @Select("SELECT * FROM maintenance_db.items_t WHERE (items_company=#{items_company})")
    List<Items> itemsForBase(String items_company);
}
