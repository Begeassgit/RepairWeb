package com.repair.web.Service.AE;

import com.repair.web.Dao.DeviceDao;
import com.repair.web.Dao.ItemsDao;
import com.repair.web.Entity.Device;
import com.repair.web.Entity.Items;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


@Service
public class DeviceAEService {
    private final DeviceDao deviceDao;
    private final ItemsDao itemsDao;

    public DeviceAEService(DeviceDao deviceDao,ItemsDao itemsDao){
        this.deviceDao=deviceDao;
        this.itemsDao=itemsDao;
    }


    public List<Device> findDeviceInfo(String companyDevice){
        return deviceDao.findDeviceInfo(companyDevice);
    }

    public List<Device>companyBase(String company){
        return deviceDao.deviceForBase(company);
    }

    public boolean delDevice(String device_id){
        return deviceDao.delOne(device_id)>=1;
    }

    public boolean delItem(String items_id){
        return itemsDao.delOne(items_id)>=1;
    }

    public XSSFWorkbook sheetOutput(String company){
        List<Device> list= deviceDao.findDeviceInfo(company);
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Device");
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
        for(Device device:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(device.getDevice_id());
            row.createCell(1).setCellValue(device.getDevice_name());
            row.createCell(2).setCellValue(device.getDevice_type());
            row.createCell(3).setCellValue(device.getDevice_brand());
            row.createCell(4).setCellValue(device.getDevice_time());
            row.createCell(5).setCellValue(device.getDevice_info());
            row.createCell(6).setCellValue(device.getDevice_company());
            row.createCell(7).setCellValue(device.getDevice_department());
            cell++;
        }
        return wb;
    }

    public XSSFWorkbook sheetOutputItem(String company){
        List<Items> list= itemsDao.itemsForBase(company);
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Item");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("耗材编号");
        titleRow.createCell(1).setCellValue("耗材名称");
        titleRow.createCell(2).setCellValue("耗材类型");
        titleRow.createCell(3).setCellValue("耗材品牌");
        titleRow.createCell(4).setCellValue("耗材余量");
        titleRow.createCell(5).setCellValue("备注");
        titleRow.createCell(6).setCellValue("所属公司");
        titleRow.createCell(7).setCellValue("使用部门");
        int cell=1;
        for(Items items:list){
            Row row=sheet.createRow(cell);
            row.createCell(0).setCellValue(items.getItems_id());
            row.createCell(1).setCellValue(items.getItems_name());
            row.createCell(2).setCellValue(items.getItems_type());
            row.createCell(3).setCellValue(items.getItems_brand());
            row.createCell(4).setCellValue(items.getItems_count());
            row.createCell(5).setCellValue(items.getItems_info());
            row.createCell(6).setCellValue(items.getItems_company());
            row.createCell(7).setCellValue(items.getItems_department());
            cell++;
        }
        return wb;
    }

    public XSSFWorkbook sheetOutputTemple(){
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Device");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("设备编号");
        titleRow.createCell(1).setCellValue("设备名称");
        titleRow.createCell(2).setCellValue("设备类型");
        titleRow.createCell(3).setCellValue("设备品牌");
        titleRow.createCell(4).setCellValue("取得日期");
        titleRow.createCell(5).setCellValue("备注");
        titleRow.createCell(6).setCellValue("所属公司");
        titleRow.createCell(7).setCellValue("使用部门");
        return wb;
    }

    public XSSFWorkbook sheetOutputItemTemple(){
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet=wb.createSheet("Item");
        Row titleRow=sheet.createRow(0);
        titleRow.createCell(0).setCellValue("耗材编号");
        titleRow.createCell(1).setCellValue("耗材名称");
        titleRow.createCell(2).setCellValue("耗材类型");
        titleRow.createCell(3).setCellValue("耗材品牌");
        titleRow.createCell(4).setCellValue("耗材余量");
        titleRow.createCell(5).setCellValue("备注");
        titleRow.createCell(6).setCellValue("所属公司");
        titleRow.createCell(7).setCellValue("使用部门");

        return wb;
    }

    public boolean uploadDevice(MultipartFile file){
        int flag=0;
        try{
            XSSFWorkbook book=new XSSFWorkbook(file.getInputStream());
            DataFormatter dataFormatter=new DataFormatter();
            int sheetNum=book.getNumberOfSheets();
            for(int i=0;i<sheetNum;i++){
                XSSFSheet sheet=book.getSheetAt(i);
                int rows=sheet.getPhysicalNumberOfRows();
                Device device;
                for(int j=1;j<rows;j++){
                    device=new Device();
                    XSSFRow xssfRow=sheet.getRow(j);
                    device.setDevice_id(dataFormatter.formatCellValue(xssfRow.getCell(0)));
                    device.setDevice_name(dataFormatter.formatCellValue(xssfRow.getCell(1)));
                    device.setDevice_type(dataFormatter.formatCellValue(xssfRow.getCell(2)));
                    device.setDevice_brand(dataFormatter.formatCellValue(xssfRow.getCell(3)));
                    device.setDevice_time(xssfRow.getCell(4).getDateCellValue());
                    device.setDevice_info(xssfRow.getCell(5).getStringCellValue());
                    device.setDevice_company(xssfRow.getCell(6).getStringCellValue());
                    device.setDevice_department(xssfRow.getCell(7).getStringCellValue());
                    flag=deviceDao.addDevice(device);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return flag>=1;
    }

    public boolean uploadItem(MultipartFile file){
        int flagItem=0;
        try{
            XSSFWorkbook book=new XSSFWorkbook(file.getInputStream());
            DataFormatter dataFormatter=new DataFormatter();
            int sheetNum=book.getNumberOfSheets();
            for(int i=0;i<sheetNum;i++){
                XSSFSheet sheet=book.getSheetAt(i);
                int rows=sheet.getPhysicalNumberOfRows();
                Items items;
                for(int j=1;j<rows;j++){
                    items=new Items();
                    XSSFRow xssfRow=sheet.getRow(j);
                    items.setItems_id(dataFormatter.formatCellValue(xssfRow.getCell(0)));
                    items.setItems_name(dataFormatter.formatCellValue(xssfRow.getCell(1)));
                    items.setItems_type(dataFormatter.formatCellValue(xssfRow.getCell(2)));
                    items.setItems_brand(dataFormatter.formatCellValue(xssfRow.getCell(3)));
                    items.setItems_count(xssfRow.getCell(4).getColumnIndex());
                    items.setItems_info(dataFormatter.formatCellValue(xssfRow.getCell(5)));
                    items.setItems_company(dataFormatter.formatCellValue(xssfRow.getCell(6)));
                    items.setItems_department(dataFormatter.formatCellValue(xssfRow.getCell(7)));
                    flagItem=itemsDao.addItems(items);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return flagItem>=1;
    }

    public void borrowUpdate(String department, String device_id){
        deviceDao.borrowDevice(department, device_id);
    }

    public Device getDeviceInfo(String device_id){
        return deviceDao.getDeviceInfo(device_id);
    }

    public boolean addOneDevice(Device device){
        return deviceDao.addDevice(device)>=1;
    }


}
