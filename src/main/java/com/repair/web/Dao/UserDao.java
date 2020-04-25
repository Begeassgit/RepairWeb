package com.repair.web.Dao;

import com.repair.web.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("SELECT user_username, user_company, user_phone FROM maintenance_db.user_t WHERE (user_username=#{username} AND user_password=#{password})")
    User checkLogin(String username, String password);

    @Insert("INSERT INTO maintenance_db.user_t(user_username,user_password,user_phone,user_company,user_address,user_business,user_info) VALUES (#{username},#{password},#{phone}," +
            "#{user_company},#{user_address},#{user_business},#{user_info})")
    int register(User user);
}
