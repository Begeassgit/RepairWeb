package com.repair.web.Service.AE;

import com.repair.web.Dao.AdminDao;
import com.repair.web.Entity.Admin;
import org.springframework.stereotype.Service;

@Service
public class WelcomeAEService {
    private final AdminDao adminDao;

    public WelcomeAEService(AdminDao adminDao){
        this.adminDao=adminDao;
    }

    public Admin getAdminInfo(String company){
        return adminDao.adminInfo(company);
    }
}
