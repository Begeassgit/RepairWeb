package com.repair.web.Controller.AE;/*
    Author:Yin
*/


import com.repair.web.Entity.Cars;
import com.repair.web.Service.AE.CarAEService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
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

    @RequestMapping(value = "/AddCar",method = RequestMethod.POST)
    public ModelAndView addCarFunction(Cars cars){
        Map<String,Object> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if(!carAEService.addCarService(cars)){
            modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("BaseTraffic");
        map.put("cars",carAEService.getAllCarInfo(cars.getCars_company()));
        map.put("company",cars.getCars_company());
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/OutputCar",method = RequestMethod.POST)
    public void getFileList(HttpServletResponse response, String company){
        XSSFWorkbook xssfWorkbook=carAEService.carSheetOutput(company);
        String fileName="交通用具表.xlsx";
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
}
