package com.repair.web.Controller.AE;

import com.repair.web.Entity.Company;
import com.repair.web.Service.AE.WelcomeAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeAEController {
    private final WelcomeAEService welcomeAEService;

    public WelcomeAEController(WelcomeAEService welcomeAEService){
        this.welcomeAEService=welcomeAEService;
    }

    @RequestMapping(value = "/WelcomeBase",method = RequestMethod.POST)
    public ModelAndView welcomeBasePage(String company){
        Map<String, String> map=new HashMap<>();
        Company infoCompany=welcomeAEService.getCompanyInfo(company);
        map.put("admin",infoCompany.getCompany_name());
        map.put("companyName",infoCompany.getCompany_name());
        map.put("address",infoCompany.getCompany_address());
        map.put("business",infoCompany.getCompany_business());
        map.put("info",infoCompany.getCompany_info());
        map.put("phone",infoCompany.getCompany_phone());
        map.put("time",infoCompany.getCompany_time().toString());
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("WelcomeBase");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
