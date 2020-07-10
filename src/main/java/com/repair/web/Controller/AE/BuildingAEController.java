package com.repair.web.Controller.AE;/*
    Author:Yin
*/

import com.repair.web.Service.AE.BuildingAEService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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

    public void outputBuilding(HttpServletResponse response,String company){
        XSSFWorkbook xssfWorkbook;

    }

}
