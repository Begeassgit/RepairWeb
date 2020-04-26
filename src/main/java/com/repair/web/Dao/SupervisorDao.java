package com.repair.web.Dao;

import com.repair.web.Entity.Supervisor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface SupervisorDao {
    @Select("SELECT super_username,super_company,super_department,super_phone FROM maintenance_db.supervisor_t WHERE(super_username=#{super_username} AND super_password=#{super_password})")
    Supervisor checkSuperLogin(String super_username,String super_password);

    @Insert("INSERT INTO maintenance_db.supervisor_t(super_username,super_password,super_company,super_department," +
            "super_phone) VALUES (#{super_username},#{super_password},#{super_company},#{super_department},#{super_phone})")
    int register(Supervisor supervisor);

    @Select("SELECT * FROM maintenance_db.supervisor_t WHERE(super_username=#{super_username} AND super_company=#{super_company})")
    Supervisor superInfo(String super_username,String super_company);
}
