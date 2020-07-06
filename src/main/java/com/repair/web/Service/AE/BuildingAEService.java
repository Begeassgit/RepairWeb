package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.BuildingDao;
import com.repair.web.Entity.Building;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingAEService {
    private final BuildingDao buildingDao;

    public BuildingAEService(BuildingDao buildingDao){
        this.buildingDao=buildingDao;
    }

    public List<Building> getAllBuilding(String company){
        return buildingDao.getAllBuilding(company);
    }
}
