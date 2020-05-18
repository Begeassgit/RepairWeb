package com.repair.web.Controller.FE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ScannerController {

    @RequestMapping(value = "/Scan",method = RequestMethod.POST)
    public ModelAndView scanPage(String user_username,String user_company,String user_department){
        Map<String,String> map=new HashMap<>();
        map.put("company",user_company);
        map.put("username",user_username);
        map.put("department",user_department);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Scan");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
