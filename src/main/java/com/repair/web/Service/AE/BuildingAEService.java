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

    public XSSFWorkbook sheetOutPutBuilding(){
        List<Building> list= new ArrayList<>();
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Building");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("设备编号");
        titleRow.createCell(1).setCellValue("设备名称");
        titleRow.createCell(2).setCellValue("设备类型");
        titleRow.createCell(3).setCellValue("设备品牌");
        titleRow.createCell(4).setCellValue("取得日期");
        titleRow.createCell(5).setCellValue("备注");
        titleRow.createCell(6).setCellValue("所属公司");
        titleRow.createCell(7).setCellValue("使用部门");
        int cell=1;
        for(Building building:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue("");
            row.createCell(1).setCellValue("device.getDevice_name()");
            row.createCell(2).setCellValue("device.getDevice_type()");
            row.createCell(3).setCellValue("device.getDevice_brand()");
            row.createCell(4).setCellValue("device.getDevice_time()");
            row.createCell(5).setCellValue("device.getDevice_info()");
            row.createCell(6).setCellValue("device.getDevice_company()");
            row.createCell(7).setCellValue("device.getDevice_department()");
            cell++;
        }
        return wb;
    }
}
