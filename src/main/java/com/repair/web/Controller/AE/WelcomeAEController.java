package com.repair.web.Controller.AE;

import com.repair.web.Entity.Admin;
import com.repair.web.Service.AE.WelcomeAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeAEController {
    private final WelcomeAEService welcomeAEService;

    public WelcomeAEController(WelcomeAEService welcomeAEService){
        this.welcomeAEService=welcomeAEService;
    }

    @RequestMapping(value = "/WelcomeBase",method = RequestMethod.POST)
    public ModelAndView welcomeBasePage(String company){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("WelcomeBase");
        modelAndView.addObject("admin",welcomeAEService.getAdminInfo(company));
        return modelAndView;
    }
}
