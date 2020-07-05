package com.repair.web.Controller.AE;/*
    Author:Yin
*/


import com.repair.web.Service.AE.CarAEService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CarsAEController {
    private final CarAEService carAEService;

    public CarsAEController(CarAEService carAEService){
        this.carAEService=carAEService;
    }

    @RequestMapping(value = "/BaseCar",method = RequestMethod.POST)
    public ModelAndView BaseCarPage(String company){
        Map<String,Object> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("BaseTraffic");
        map.put("cars",carAEService.getAllCarInfo(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelCar",method = RequestMethod.POST)
    public ModelAndView delCarFunction(String cars_id,String company){
        Map<String,Object> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if(!carAEService.delCarService(cars_id, company)){
            modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("BaseTraffic");
        map.put("cars",carAEService.getAllCarInfo(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/BorrowCarOut",method = RequestMethod.POST)
    public ModelAndView borrowCarOutFunction(String cars_id,String department,String company){
        Map<String,Object> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if(!carAEService.borrowCarService(cars_id, department, company)){
            modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("BaseTraffic");
        map.put("cars",carAEService.getAllCarInfo(company));
        map.put("company",company);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
