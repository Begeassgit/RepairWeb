package com.repair.web.Dao;

import com.repair.web.Entity.Device;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceDao {
    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_id=#{device_id})")
    Device getDeviceInfo(String device_id);

    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_id=#{device_id})")
    List<Device> findDeviceQr(String device_id);

    @Insert("INSERT INTO maintenance_db.device_t(device_id,device_name,device_type,device_brand,device_time,device_info,device_company,device_department)" +
            "VALUES(#{device_id},#{device_name},#{device_type},#{device_brand},#{device_time},#{device_info},#{device_company},#{device_department})")
    int addDevice(Device device);

    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_company LIKE #{device_company})")
    List<Device> findDeviceInfo(String device_company);

    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_company=#{device_company})")
    List<Device> deviceForBase(String device_company);

    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_company = #{device_company} AND device_department=#{device_department})")
    List<Device> ComDeviceInfo(String device_company,String device_department);

    @Select("SELECT COUNT(device_id) FROM maintenance_db.device_t WHERE (device_company=#{device_company} AND device_department=#{device_department})")
    int getDeviceSum(String device_company,String device_department);

    @Delete("DELETE FROM maintenance_db.device_t WHERE (device_id=#{device_id})")
    int delOne(String device_id);

    @Update("UPDATE maintenance_db.device_t SET device_department=#{device_department} WHERE (device_id=#{device_id})")
    int returnDevice(String device_department,String device_id);

    @Update("UPDATE maintenance_db.device_t SET device_department=#{device_department} WHERE (device_id=#{device_id})")
    int borrowDevice(String device_department,String device_id);

    @Select("SELECT * FROM maintenance_db.device_t WHERE ((device_id=#{device_id} OR device_name=#{device_name}" +
            "OR device_brand=#{device_brand} OR device_type=#{device_type}) AND (device_company=#{device_company} AND device_department=#{device_department}))")
    List<Device> findDevice(Device device);
}
