package com.repair.web.Dao;

import com.repair.web.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select("SELECT user_username, user_company, user_phone FROM maintenance_db.user_t WHERE (user_username=#{username} AND user_password=#{password})")
    User checkLogin(String username, String password);

    @Insert("INSERT INTO maintenance_db.user_t(user_username,user_password,user_phone,user_company,user_address,user_info,user_department) VALUES (#{username},#{password},#{phone}," +
            "#{user_company},#{user_address},#{user_info}),#{user_department}")
    int register(User user);

    @Select("SELECT * FROM maintenance_db.user_t WHERE(user_company=#{user_company} AND user_department=#{user_department}")
    List<User> getUser(String user_company,String user_department);

    @Update("UPDATE maintenance_db.user_t SET user_password=#{password} WHERE (user_id=#{user_id})")
    int rest(String password,String user_id);

    @Delete("DELETE FROM maintenance_db.user_t WHERE (user_id=#{user_id})")
    int delOne(String user_id);
}
