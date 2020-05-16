package com.repair.web.Service.AE;

import com.repair.web.Dao.TakeListDao;
import com.repair.web.Entity.TakeList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TakeListAEService {
    private long count=0;
    private final TakeListDao takeListDao;


    public TakeListAEService(TakeListDao takeListDao){
        this.takeListDao=takeListDao;
    }

    public List<TakeList> getTakeList(String company){
        return takeListDao.getTakeList(company);
    }

    public boolean addTakeList(TakeList takeList){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        String StrCount=String.format("%06d",count);
        takeList.setTake_list_time(date);
        takeList.setTake_list_list_id(simpleDateFormat.format(new Date())+StrCount);
        count++;
        return takeListDao.addTakeList(takeList)>=1;
    }

    public XSSFWorkbook sheetOutput(String company){
        List<TakeList> lists=takeListDao.getTakeList(company);
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook();
        Sheet sheet=xssfWorkbook.createSheet("List");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("领用单编号");
        titleRow.createCell(1).setCellValue("类型");
        titleRow.createCell(2).setCellValue("耗材/设备号");
        titleRow.createCell(3).setCellValue("耗材/设备名");
        titleRow.createCell(4).setCellValue("领用部门");
        titleRow.createCell(5).setCellValue("领用时间");
        titleRow.createCell(6).setCellValue("公司");
        int cell=1;
        for(TakeList takeList:lists){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(takeList.getTake_list_list_id());
            row.createCell(1).setCellValue(takeList.getTake_list_type());
            row.createCell(2).setCellValue(takeList.getTake_list_id());
            row.createCell(3).setCellValue(takeList.getTake_list_name());
            row.createCell(4).setCellValue(takeList.getTake_list_time());
            row.createCell(5).setCellValue(takeList.getTake_list_department());
            row.createCell(6).setCellValue(takeList.getTake_list_company());
            cell++;

        }
        return xssfWorkbook;
    }

    public boolean delList(String list_id){
        return takeListDao.delOneList(list_id)>=1;
    }
}