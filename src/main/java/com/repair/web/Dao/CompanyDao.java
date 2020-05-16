package com.repair.web.Dao;

import com.repair.web.Entity.Company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface CompanyDao {
    @Select("SELECT * FROM maintenance_db.company_t WHERE company_name=#{company_name}")
    Company getInfo(String company_name);

    @Insert("INSERT INTO maintenance_db.company_t(company_name,company_info,company_address,company_business,company_phone,company_time)" +
            "VALUES(#{company_name},#{company_info},#{company_address},#{company_business},#{company_phone},#{company_time})")
    int registerCompany(Company company);
}
