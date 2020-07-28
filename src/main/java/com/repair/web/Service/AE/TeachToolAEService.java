package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.TeachToolDao;
import com.repair.web.Entity.Cars;
import com.repair.web.Entity.TeachTool;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public XSSFWorkbook outputSheet(String company){
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        List<TeachTool> list=teachToolDao.getAllTeachTool(company);
        Sheet sheet=xssfWorkbook.createSheet("TeachTool");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("名称");
        titleRow.createCell(2).setCellValue("品牌");
        titleRow.createCell(3).setCellValue("状态");
        titleRow.createCell(4).setCellValue("数量");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(TeachTool teachTool:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(teachTool.getTeach_tool_id());
            row.createCell(1).setCellValue(teachTool.getTeach_tool_name());
            row.createCell(2).setCellValue(teachTool.getTeach_tool_brand());
            row.createCell(3).setCellValue(teachTool.getTeach_tool_status());
            row.createCell(4).setCellValue(teachTool.getTeach_tool_count());
            row.createCell(5).setCellValue(teachTool.getTeach_tool_company());
            cell++;
        }
        return xssfWorkbook;

    }

    public XSSFWorkbook outputSheetTemplate(){
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        List<TeachTool> list=new ArrayList<>();
        Sheet sheet=xssfWorkbook.createSheet("TeachTool");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("名称");
        titleRow.createCell(2).setCellValue("品牌");
        titleRow.createCell(3).setCellValue("状态");
        titleRow.createCell(4).setCellValue("数量");
        titleRow.createCell(5).setCellValue("所属公司");
        int cell=1;
        for(TeachTool teachTool:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(teachTool.getTeach_tool_id());
            row.createCell(1).setCellValue(teachTool.getTeach_tool_name());
            row.createCell(2).setCellValue(teachTool.getTeach_tool_brand());
            row.createCell(3).setCellValue(teachTool.getTeach_tool_status());
            row.createCell(4).setCellValue(teachTool.getTeach_tool_count());
            row.createCell(5).setCellValue(teachTool.getTeach_tool_company());
            cell++;
        }
        return xssfWorkbook;

    }
}
