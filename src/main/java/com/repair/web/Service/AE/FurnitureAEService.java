package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.FurnitureDao;
import com.repair.web.Entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureAEService {
    private final FurnitureDao furnitureDao;

    public FurnitureAEService(FurnitureDao furnitureDao){
        this.furnitureDao=furnitureDao;
    }

    public List<Furniture> getAllFurniture(String company){
        return furnitureDao.getAllFurniture(company);
    }
}
