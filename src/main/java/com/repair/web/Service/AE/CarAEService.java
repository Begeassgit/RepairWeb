package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.CarsDao;
import com.repair.web.Entity.Cars;
import com.repair.web.Entity.Device;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    public boolean addOneCar(Cars cars){
        return carsDao.addCar(cars)>=1;
    }

    public XSSFWorkbook outputCarSheet(String company){
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        List<Cars> list=carsDao.getAllCar(company);
        Sheet sheet=xssfWorkbook.createSheet("交通载具");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("车辆编号");
        titleRow.createCell(1).setCellValue("车辆型号");
        titleRow.createCell(2).setCellValue("车辆品牌");
        titleRow.createCell(3).setCellValue("状态");
        titleRow.createCell(4).setCellValue("使用部门");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Cars cars:list){
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

    public XSSFWorkbook outputCarSheetTemplate(){
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        List<Cars> list=new ArrayList<>();
        Sheet sheet=xssfWorkbook.createSheet("交通载具-模板");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("车辆编号");
        titleRow.createCell(1).setCellValue("车辆型号");
        titleRow.createCell(2).setCellValue("车辆品牌");
        titleRow.createCell(3).setCellValue("状态");
        titleRow.createCell(4).setCellValue("使用部门");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Cars cars:list){
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

    public boolean uploadCar(MultipartFile file){
        int flag=0;
        try{
            XSSFWorkbook book=new XSSFWorkbook(file.getInputStream());
            DataFormatter dataFormatter=new DataFormatter();
            int sheetNum=book.getNumberOfSheets();
            for(int i=0;i<sheetNum;i++){
                XSSFSheet sheet=book.getSheetAt(i);
                int rows=sheet.getPhysicalNumberOfRows();
                Device device=null;
                for(int j=1;j<rows;j++){
                    Cars cars=new Cars();
                    XSSFRow xssfRow=sheet.getRow(j);
                    cars.setCars_id(dataFormatter.formatCellValue(xssfRow.getCell(0)));
                    cars.setCars_name(dataFormatter.formatCellValue(xssfRow.getCell(1)));
                    cars.setCars_brand(dataFormatter.formatCellValue(xssfRow.getCell(2)));
                    cars.setCars_status(dataFormatter.formatCellValue(xssfRow.getCell(3)));
                    cars.setCars_department(dataFormatter.formatCellValue(xssfRow.getCell(4)));
                    cars.setCars_company(dataFormatter.formatCellValue(xssfRow.getCell(5)));
                    flag=carsDao.addCar(cars);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return flag>=1;

    }
}
