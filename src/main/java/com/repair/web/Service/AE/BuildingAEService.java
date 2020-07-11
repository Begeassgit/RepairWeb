package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.BuildingDao;
import com.repair.web.Entity.Building;
import com.repair.web.Entity.Device;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
