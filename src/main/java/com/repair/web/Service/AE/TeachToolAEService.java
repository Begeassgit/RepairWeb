package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.TeachToolDao;
import com.repair.web.Entity.TeachTool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachToolAEService {
    private final TeachToolDao teachToolDao;

    public TeachToolAEService(TeachToolDao teachToolDao){
        this.teachToolDao=teachToolDao;
    }

    public List<TeachTool> getAllTeachTool(String company){
        return teachToolDao.getAllTeachTool(company);
    }

    public boolean delTeachToolService(String id,String company){
        return teachToolDao.delTeachTool(id, company)>=1;
    }
}
