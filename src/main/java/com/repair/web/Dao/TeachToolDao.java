package com.repair.web.Dao;/*
    Author:Yin
*/

import com.repair.web.Entity.TeachTool;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeachToolDao {
    @Select("SELECT teach_tool_name,teach_tool_brand,teach_tool_status,teach_tool_count,teach_tool_department,teach_tool_company,teach_tool_id FROM teach_tool_t" +
            " WHERE(teach_tool_company=#{company})")
    List<TeachTool> getAllTeachTool(String company);

    @Delete("DELETE FROM teach_tool_t WHERE teach_tool_id=#{id} AND teach_tool_company=#{company}")
    int delTeachTool(String id,String company);
}
