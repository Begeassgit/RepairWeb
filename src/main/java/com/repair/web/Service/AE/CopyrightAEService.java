package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.CopyrightDao;
import com.repair.web.Entity.Copyright;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyrightAEService {
    private final CopyrightDao copyrightDao;

    public CopyrightAEService(CopyrightDao copyrightDao){
        this.copyrightDao=copyrightDao;
    }

    public List<Copyright> getAllCopyright(String company){
        return copyrightDao.getAllCopyright(company);
    }

    public boolean delCopyright(String id,String company){
        return copyrightDao.delCopyright(id, company)>=1;
    }
}
