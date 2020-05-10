package com.repair.web.Controller.AE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.AE.DeviceAEService;
import com.repair.web.Service.AE.ItemsAEService;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceAEController {
 public final DeviceAEService deviceAEService;
 public final ItemsAEService itemsAEService;

    public DeviceAEController(DeviceAEService deviceAEService,ItemsAEService itemsAEService){
        this.deviceAEService=deviceAEService;
        this.itemsAEService=itemsAEService;
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

        modelAndView.setViewName("Base");
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
    public void uploadDevice(@Param("file")MultipartFile file){
        if(!deviceAEService.uploadDevice(file)){

        }
    }

    @RequestMapping(value = "/UploadItem",method = RequestMethod.POST)
    public void uploadItem(@Param("file")MultipartFile file){
        if(!deviceAEService.uploadItem(file)){

        }
    }

}
