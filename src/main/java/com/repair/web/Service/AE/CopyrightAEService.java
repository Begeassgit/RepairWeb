package com.repair.web.Service.AE;/*
    Author:Yin
*/

import com.repair.web.Dao.CopyrightDao;
import com.repair.web.Entity.Cars;
import com.repair.web.Entity.Copyright;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CopyrightAEService {
    private final CopyrightDao copyrightDao;

    public CopyrightAEService(CopyrightDao copyrightDao){
        this.copyrightDao=copyrightDao;
    }

    public List<Copyright> getAllCopyright(String company){
        return copyrightDao.getAllCopyright(company);
    }

    public boolean delCopyright(String id,String company){
        return copyrightDao.delCopyright(id, company)>=1;
    }

    public XSSFWorkbook outputSheet(String company){
        List<Copyright> list=copyrightDao.getAllCopyright(company);
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        Sheet sheet=xssfWorkbook.createSheet("Copyright");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("土地使用权/软件名");
        titleRow.createCell(2).setCellValue("信息");
        titleRow.createCell(3).setCellValue("相关部门");
        titleRow.createCell(4).setCellValue("所属公司");
        int cell=1;
        for(Copyright copyright:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(copyright.getCopyright_id());
            row.createCell(1).setCellValue(copyright.getCopyright_name());
            row.createCell(2).setCellValue(copyright.getCopyright_info());
            row.createCell(3).setCellValue(copyright.getCopyright_department());
            row.createCell(4).setCellValue(copyright.getCopyright_company());
            cell++;
        }
        return xssfWorkbook;
    }

    public XSSFWorkbook outputSheetTemplate(){
        List<Copyright> list=new ArrayList<>();
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        Sheet sheet=xssfWorkbook.createSheet("Copyright");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("编号");
        titleRow.createCell(1).setCellValue("土地使用权/软件名");
        titleRow.createCell(2).setCellValue("信息");
        titleRow.createCell(3).setCellValue("相关部门");
        titleRow.createCell(4).setCellValue("所属公司");
        int cell=1;
        for(Copyright copyright:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(copyright.getCopyright_id());
            row.createCell(1).setCellValue(copyright.getCopyright_name());
            row.createCell(2).setCellValue(copyright.getCopyright_info());
            row.createCell(3).setCellValue(copyright.getCopyright_department());
            row.createCell(4).setCellValue(copyright.getCopyright_company());
            cell++;
        }
        return xssfWorkbook;
    }
}
