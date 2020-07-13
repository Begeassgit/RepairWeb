package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.FurnitureDao;
import com.repair.web.Entity.Cars;
import com.repair.web.Entity.Furniture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public XSSFWorkbook outputFurnitureSheet(String company){
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        List<Furniture> list=furnitureDao.getAllFurniture(company);
        Sheet sheet=xssfWorkbook.createSheet("家具用具");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("家具用具类型");
        titleRow.createCell(2).setCellValue("家具用具名字");
        titleRow.createCell(3).setCellValue("家具用具品牌");
        titleRow.createCell(4).setCellValue("家具用具余量");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Furniture furniture:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(furniture.getFurniture_id());
            row.createCell(1).setCellValue(furniture.getFurniture_type());
            row.createCell(2).setCellValue(furniture.getFurniture_name());
            row.createCell(3).setCellValue(furniture.getFurniture_brand());
            row.createCell(4).setCellValue(furniture.getFurniture_count());
            row.createCell(5).setCellValue(furniture.getFurniture_company());
            cell++;
        }
        return xssfWorkbook;
    }

    public XSSFWorkbook outputFurnitureSheetTemplate(){
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        List<Furniture> list=new ArrayList<>();
        Sheet sheet=xssfWorkbook.createSheet("家具用具");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("家具用具类型");
        titleRow.createCell(2).setCellValue("家具用具名字");
        titleRow.createCell(3).setCellValue("家具用具品牌");
        titleRow.createCell(4).setCellValue("家具用具余量");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Furniture furniture:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(furniture.getFurniture_id());
            row.createCell(1).setCellValue(furniture.getFurniture_type());
            row.createCell(2).setCellValue(furniture.getFurniture_name());
            row.createCell(3).setCellValue(furniture.getFurniture_brand());
            row.createCell(4).setCellValue(furniture.getFurniture_count());
            row.createCell(5).setCellValue(furniture.getFurniture_company());
            cell++;
        }
        return xssfWorkbook;
    }
}
