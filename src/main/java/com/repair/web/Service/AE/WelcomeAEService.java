package com.repair.web.Service.AE;

import com.repair.web.Dao.AdminDao;
import com.repair.web.Dao.CompanyDao;
import com.repair.web.Entity.Admin;
import com.repair.web.Entity.Company;
import org.springframework.stereotype.Service;

@Service
public class WelcomeAEService {
    private final AdminDao adminDao;
    private final CompanyDao companyDao;

    public WelcomeAEService(AdminDao adminDao,CompanyDao companyDao){
        this.adminDao=adminDao;
        this.companyDao=companyDao;
    }

    public Admin getAdminInfo(String company){
        return adminDao.adminInfo(company);
    }

    public Company getCompanyInfo(String company){return companyDao.getInfo(company);}
}
