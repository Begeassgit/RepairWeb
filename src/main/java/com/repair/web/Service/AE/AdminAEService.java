package com.repair.web.Service.AE;

import com.repair.web.Dao.AdminDao;
import com.repair.web.Entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminAEService {
    public final AdminDao adminDao;

    public AdminAEService(AdminDao adminDao){
        this.adminDao=adminDao;
    }

    public Admin checkAdminLogin(String username,String password){
        if(adminDao.checkAdminLogin(username,password)==null){
            return null;
        }
        return adminDao.checkAdminLogin(username,password);
    }
}
