package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.CarsDao;
import com.repair.web.Entity.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarAEService {
    @Autowired
    private final CarsDao carsDao;

    public CarAEService(CarsDao carsDao){
        this.carsDao=carsDao;
    }

    public List<Cars> getAllCarInfo(String cars_company){
        return carsDao.getAllCar(cars_company);
    }

    public boolean delCarService(String cars_id,String company){
        return carsDao.delCar(cars_id, company)>=1;
    }

    public boolean borrowCarService(String cars_id,String cars_company,String cars_department){
        return carsDao.borrowOut(cars_id, cars_company, cars_department)>=1;
    }
}
