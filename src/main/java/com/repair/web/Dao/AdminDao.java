package com.repair.web.Dao;

import com.repair.web.Entity.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminDao {
    @Select("SELECT admin_company FROM maintenance_db.admin_t WHERE(admin_username=#{username} AND admin_password=#{password})")
    Admin checkAdminLogin(String username,String password);

    @Select("SELECT admin_company FROM maintenance_db.admin_t WHERE(admin_company=#{admin_company})")
    Admin adminInfo(String admin_company);
}
