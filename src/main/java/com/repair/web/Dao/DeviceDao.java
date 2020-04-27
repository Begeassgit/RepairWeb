package com.repair.web.Dao;

import com.repair.web.Entity.Device;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeviceDao {
    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_id=#{device_id})")
    List<Device> getDeviceInfo(String device_id);

    @Insert("INSERT INTO maintenance_db.device_t(device_id,device_name,device_type,device_brand,device_time,device_info,device_company)" +
            "VALUES(#{device_id},#{device_name},#{device_type},#{device_brand},#{device_time},#{device_info},#{device_company})")
    int addDevice(Device device);

    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_company LIKE #{device_company})")
    List<Device> findDeviceInfo(String device_company);

    @Select("SELECT * FROM maintenance_db.device_t WHERE (device_company = #{device_company})")
    List<Device> ComDeviceInfo(String device_company);
}
