package com.repair.web.Controller.AE;

import com.repair.web.Entity.Device;
import com.repair.web.Entity.Items;
import com.repair.web.Entity.TakeList;
import com.repair.web.Service.AE.DeviceAEService;
import com.repair.web.Service.AE.ItemsAEService;
import com.repair.web.Service.AE.TakeListAEService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DeviceAEController {
 private final DeviceAEService deviceAEService;
 private final ItemsAEService itemsAEService;
 private final TakeListAEService takeListAEService;

    public DeviceAEController(DeviceAEService deviceAEService,ItemsAEService itemsAEService,TakeListAEService takeListAEService){
        this.deviceAEService=deviceAEService;
        this.itemsAEService=itemsAEService;
        this.takeListAEService=takeListAEService;
    }

    @RequestMapping(value = "/DeviceInfoAE",method = RequestMethod.GET)
    public String getDeviceInfoPage(){
        return "";
    }

    @RequestMapping(value = "/FindDeviceInfoAE",method = RequestMethod.POST)
    public List<Device> findDeviceInfo(String deviceCompany){
        deviceCompany='%'+deviceCompany+'%';
        return deviceAEService.findDeviceInfo(deviceCompany);
    }

    @RequestMapping(value = "/Base",method = RequestMethod.POST)
    public ModelAndView basePage(String company){
        Map<String,List> map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("device",deviceAEService.companyBase(company));
        map.put("company",list);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Base");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/BaseItem",method = RequestMethod.POST)
    public ModelAndView basePageItems(String company){
        Map<String,List> map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("items",itemsAEService.itemsForBase(company));
        map.put("company",list);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("BaseItems");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelAE",method = RequestMethod.POST)
    public ModelAndView delOne(String company,String device_id){
        Map<String,List> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        List list=new ArrayList();
        list.add(0,company);
        if(!deviceAEService.delDevice(device_id)){
            modelAndView.setViewName("Error");
        }
        map.put("device",deviceAEService.companyBase(company));
        map.put("items",itemsAEService.itemsForBase(company));
        map.put("company",list);

        modelAndView.setViewName("Base");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelAEItems",method = RequestMethod.POST)
    public ModelAndView delOneItems(String company,String items_id){
        Map<String,List> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        List list=new ArrayList();
        list.add(0,company);
        if(!deviceAEService.delItem(items_id)){
            modelAndView.setViewName("Error");
        }
        map.put("device",deviceAEService.companyBase(company));
        map.put("items",itemsAEService.itemsForBase(company));
        map.put("company",list);

        modelAndView.setViewName("BaseItems");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/OutputDe",method = RequestMethod.POST)
    public void getFileDe(HttpServletResponse response,String company){
        XSSFWorkbook xssfWorkbook=deviceAEService.sheetOutput(company);
        String fileName="固定资产.xlsx";
        OutputStream outputStream;
        try{
            fileName= URLEncoder.encode(fileName,"UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
            outputStream=response.getOutputStream();
            xssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException eio){
            eio.printStackTrace();
        }
    }

    @RequestMapping(value = "/OutputItem",method = RequestMethod.POST)
    public void getFileItem(HttpServletResponse response,String company){
        XSSFWorkbook xssfWorkbook=deviceAEService.sheetOutputItem(company);
        String fileName="耗材.xlsx";
        OutputStream outputStream;
        try{
            fileName= URLEncoder.encode(fileName,"UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition","attachment;filename="+fileName);
            outputStream=response.getOutputStream();
            xssfWorkbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException eio){
            eio.printStackTrace();
        }
    }

    @RequestMapping(value = "/UploadDe",method = RequestMethod.POST)
    public ModelAndView uploadDevice(@RequestParam("file")MultipartFile file,String company){
        ModelAndView modelAndView=new ModelAndView();
        if(!deviceAEService.uploadDevice(file)){
            modelAndView.setViewName("Error");
        }
        else {
            Map<String,List> map=new HashMap<>();
            List list=new ArrayList();
            list.add(0,company);
            map.put("device",deviceAEService.companyBase(company));
            map.put("company",list);
            modelAndView.setViewName("Base");
            modelAndView.addAllObjects(map);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/UploadItem",method = RequestMethod.POST)
    public ModelAndView uploadItem(@RequestParam("file")MultipartFile file,String company){
        ModelAndView modelAndView=new ModelAndView();
        if(!deviceAEService.uploadItem(file)){
            modelAndView.setViewName("Error");
        }
        else {
            Map<String,List> map=new HashMap<>();
            List list=new ArrayList();
            list.add(0,company);
            map.put("items",itemsAEService.itemsForBase(company));
            map.put("company",list);
            modelAndView.setViewName("BaseItems");
            modelAndView.addAllObjects(map);

        }

        return modelAndView;
    }

    @RequestMapping(value = "/UpdateDe",method = RequestMethod.POST)
    public ModelAndView updateDe(String company,String department,String device_id){
        TakeList takeList=new TakeList();
        takeList.setTake_list_id(device_id);
        takeList.setTake_list_name(deviceAEService.getDeviceInfo(device_id).getDevice_name());
        takeList.setTake_list_department(department);
        takeList.setTake_list_company(company);
        takeList.setTake_list_type("设备");
        takeListAEService.addTakeList(takeList);
        deviceAEService.borrowUpdate(department,device_id);
        ModelAndView modelAndView=new ModelAndView();
        Map<String,List> map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("device",deviceAEService.companyBase(company));
        map.put("company",list);
        modelAndView.setViewName("Base");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/UpdateItem",method = RequestMethod.POST)
    public ModelAndView updateItem(String company,String department,String item_id,String number){
        int num= Integer.parseInt(number);
        TakeList takeList=new TakeList();
        takeList.setTake_list_id(item_id);
        takeList.setTake_list_name(itemsAEService.getItemsInfo(item_id).getItems_name());
        takeList.setTake_list_department(department);
        takeList.setTake_list_company(company);
        takeList.setTake_list_type("耗材");
        takeListAEService.addTakeList(takeList);
        itemsAEService.borrowUpdate(department,item_id,num);
        ModelAndView modelAndView=new ModelAndView();
        Map<String,List> map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("items",itemsAEService.itemsForBase(company));
        map.put("company",list);
        modelAndView.setViewName("BaseItems");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/AddOneDe",method = RequestMethod.POST)
    public ModelAndView addOneDe(String device_id, String name, String type, String brand, String info, String company, String time) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=simpleDateFormat.parse(time);
        Device device=new Device();
        device.setDevice_department("");
        device.setDevice_company(company);
        device.setDevice_id(device_id);
        device.setDevice_name(name);
        device.setDevice_type(type);
        device.setDevice_brand(brand);
        device.setDevice_info(info);
        device.setDevice_time(date);

        ModelAndView modelAndView=new ModelAndView();
        if(!deviceAEService.addOneDevice(device)){
            modelAndView.setViewName("Error");
            return modelAndView;
        }
        Map<String,List> map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("device",deviceAEService.companyBase(company));
        map.put("company",list);
        modelAndView.setViewName("Base");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/AddOneItems",method = RequestMethod.POST)
    public ModelAndView addOneItems(String items_id, String name, String type, String brand, String info, String company, String count){
        Items items=new Items();
        items.setItems_department("");
        items.setItems_company(company);
        items.setItems_name(name);
        items.setItems_id(items_id);
        items.setItems_type(type);
        items.setItems_count(Integer.parseInt(count));
        items.setItems_brand(brand);
        items.setItems_info(info);

        ModelAndView modelAndView=new ModelAndView();
        if(!itemsAEService.addOneItems(items)){
            modelAndView.setViewName("Error");
            return modelAndView;
        }
        Map<String,List> map=new HashMap<>();
        List list=new ArrayList();
        list.add(0,company);
        map.put("items",itemsAEService.itemsForBase(company));
        map.put("company",list);
        modelAndView.setViewName("BaseItems");
        modelAndView.addAllObjects(map);
        return modelAndView;

    }

}
