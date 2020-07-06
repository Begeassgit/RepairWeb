package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.CarsDao;
import com.repair.web.Entity.Cars;
import com.repair.web.Entity.TakeList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

    public boolean addCarService(Cars cars){
        return carsDao.addCar(cars)>=1;
    }

    public XSSFWorkbook carSheetOutput(String company){
        List<Cars> lists=carsDao.getAllCar(company);
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        Sheet sheet=xssfWorkbook.createSheet("List");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("载具编号");
        titleRow.createCell(1).setCellValue("型号");
        titleRow.createCell(2).setCellValue("品牌");
        titleRow.createCell(3).setCellValue("状态");
        titleRow.createCell(4).setCellValue("所属部门");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Cars cars:lists){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(cars.getCars_id());
            row.createCell(1).setCellValue(cars.getCars_name());
            row.createCell(2).setCellValue(cars.getCars_brand());
            row.createCell(3).setCellValue(cars.getCars_status());
            row.createCell(4).setCellValue(cars.getCars_department());
            row.createCell(5).setCellValue(cars.getCars_company());
            cell++;

        }
        return xssfWorkbook;
    }
}
