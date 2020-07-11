package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.BuildingDao;
import com.repair.web.Entity.Building;
import com.repair.web.Entity.Cars;
import com.repair.web.Entity.Device;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

    public boolean delOne(String id,String company){
        return buildingDao.delOne(id, company)>=1;
    }

    public XSSFWorkbook sheetOutPutBuilding(String company){
        List<Building> list= buildingDao.getAllBuilding(company);
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Building");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("房屋/附属设施名");
        titleRow.createCell(2).setCellValue("状态");
        titleRow.createCell(3).setCellValue("信息");
        titleRow.createCell(4).setCellValue("相关部门");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Building building:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(building.getBuilding_id());
            row.createCell(1).setCellValue(building.getBuilding_name());
            row.createCell(2).setCellValue(building.getBuilding_status());
            row.createCell(3).setCellValue(building.getBuilding_info());
            row.createCell(4).setCellValue(building.getBuilding_department());
            row.createCell(5).setCellValue(building.getBuilding_company());
            cell++;
        }
        return wb;
    }

    public XSSFWorkbook sheetOutPutBuildingTemplate(){
        List<Building> list= new ArrayList<>();
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Building");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("房屋/附属设施名");
        titleRow.createCell(2).setCellValue("状态");
        titleRow.createCell(3).setCellValue("信息");
        titleRow.createCell(4).setCellValue("相关部门");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(Building building:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(building.getBuilding_id());
            row.createCell(1).setCellValue(building.getBuilding_name());
            row.createCell(2).setCellValue(building.getBuilding_status());
            row.createCell(3).setCellValue(building.getBuilding_info());
            row.createCell(4).setCellValue(building.getBuilding_department());
            row.createCell(5).setCellValue(building.getBuilding_company());
            cell++;
        }
        return wb;
    }

    public boolean uploadBuilding(MultipartFile file){
        int flag=0;
        try{
            XSSFWorkbook book=new XSSFWorkbook(file.getInputStream());
            DataFormatter dataFormatter=new DataFormatter();
            int sheetNum=book.getNumberOfSheets();
            for(int i=0;i<sheetNum;i++){
                XSSFSheet sheet=book.getSheetAt(i);
                int rows=sheet.getPhysicalNumberOfRows();
                for(int j=1;j<rows;j++){
                    Building building=new Building();
                    XSSFRow xssfRow=sheet.getRow(j);
                    building.setBuilding_id(dataFormatter.formatCellValue(xssfRow.getCell(0)));
                    building.setBuilding_name(dataFormatter.formatCellValue(xssfRow.getCell(1)));
                    building.setBuilding_status(dataFormatter.formatCellValue(xssfRow.getCell(2)));
                    building.setBuilding_info(dataFormatter.formatCellValue(xssfRow.getCell(3)));
                    building.setBuilding_department(dataFormatter.formatCellValue(xssfRow.getCell(4)));
                    building.setBuilding_company(dataFormatter.formatCellValue(xssfRow.getCell(5)));
                    flag=buildingDao.addOneBuilding(building);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return flag>=1;
    }

    public boolean addOneBuilding(Building building){
        return buildingDao.addOneBuilding(building)>=1;
    }
}
