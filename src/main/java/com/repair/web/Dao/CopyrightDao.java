package com.repair.web.Dao;/*
    Author:Yin
*/

import com.repair.web.Entity.Copyright;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CopyrightDao {
    @Select("SELECT copyright_id,copyright_name,copyright_info,copyright_department,copyright_company FROM copyright_t WHERE copyright_company=#{company}")
    List<Copyright> getAllCopyright(String company);

    @Delete("DELETE FROM copyright_t WHERE copyright_company=#{company} AND copyright_id=#{id}")
    int delCopyright(String id,String company);

}
