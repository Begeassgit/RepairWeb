package com.repair.web.Dao;

import com.repair.web.Entity.Worker;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface WorkerDao {
    @Select("SELECT * FROM maintenance_db.worker_t WHERE(worker_id=#{worker_id} AND worker_password=#{worker_password})")
    Worker checkLogin(String worker_id,String worker_password);

    @Select("SELECT * FROM maintenance_db.worker_t WHERE(worker_id=#{worker_id} AND worker_name=#{worker_name})")
    Worker getInfo(String worker_id,String worker_name);

    @Insert("INSERT INTO maintenance_db.worker_t(worker_id,worker_name,worker_password,worker_takeTime,worker_sex,worker_age,worker_rank) VALUES (" +
            "#{worker_id},#{worker_name},#{worker_password},#{worker_takeTime},#{worker_sex},#{worker_age},#{worker_rank})")
    int add(Worker worker);
}
