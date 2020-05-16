package com.repair.web.Service.AE;

import com.repair.web.Dao.AdminDao;
import com.repair.web.Dao.CompanyDao;
import com.repair.web.Entity.Admin;
import com.repair.web.Entity.Company;
import org.springframework.stereotype.Service;

@Service
public class RegisterAEService {
    private final CompanyDao companyDao;
    private final AdminDao adminDao;

    public RegisterAEService(CompanyDao companyDao,AdminDao admindao){
        this.companyDao=companyDao;
        this.adminDao=admindao;
    }

    public boolean registerCompany(Company company){
        return companyDao.registerCompany(company)>=1;
    }

    public boolean registerAdmin(Admin admin){return adminDao.register(admin)>=1;}
}

