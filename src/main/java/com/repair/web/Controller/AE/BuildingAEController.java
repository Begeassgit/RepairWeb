package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Entity.Building;
import com.repair.web.Service.AE.BuildingAEService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class BuildingAEController {

    private final BuildingAEService buildingAEService;

    public BuildingAEController(BuildingAEService buildingAEService){
        this.buildingAEService=buildingAEService;
    }

    @RequestMapping(value = "/BaseBuilding",method = RequestMethod.POST)
    public ModelAndView buildingPage(String company){
        Map<String,Object>map =new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("BaseBuilding");
        map.put("BuildingList",buildingAEService.getAllBuilding(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelBuilding",method = RequestMethod.POST)
    public ModelAndView delBuilding(String company,String building_id){
        Map<String,Object>map =new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if (!buildingAEService.delOne(building_id,company)){
            modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("BaseBuilding");
        map.put("BuildingList",buildingAEService.getAllBuilding(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/OutputBuilding",method = RequestMethod.POST)
    public void outputBuilding(HttpServletResponse response,String company){
        XSSFWorkbook xssfWorkbook=buildingAEService.sheetOutPutBuilding(company);
        String fileName="房屋及附属设施.xlsx";
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

    @RequestMapping(value = "/OutputBuildingTemplate",method = RequestMethod.GET)
    public void outputBuildingTemplate(HttpServletResponse response){
        XSSFWorkbook xssfWorkbook=buildingAEService.sheetOutPutBuildingTemplate();
        String fileName="房屋及附属设施模板.xlsx";
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

    @RequestMapping(value = "/UploadBuilding",method = RequestMethod.POST)
    public ModelAndView uploadCar(@RequestParam("file") MultipartFile file, String company) {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> map = new HashMap<>();
        if (!buildingAEService.uploadBuilding(file)) {
            modelAndView.setViewName("Error");
        } else {
            map.put("company", company);
            map.put("BuildingList",buildingAEService.getAllBuilding(company));
            modelAndView.addAllObjects(map);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/AddOneBuilding",method = RequestMethod.POST)
    public ModelAndView addOneBuilding(Building building){
        Map<String,Object>map =new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if (!buildingAEService.addOneBuilding(building)){
            modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("BaseBuilding");
        map.put("BuildingList",buildingAEService.getAllBuilding(building.getBuilding_company()));
        map.put("company",building.getBuilding_company());
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

}
