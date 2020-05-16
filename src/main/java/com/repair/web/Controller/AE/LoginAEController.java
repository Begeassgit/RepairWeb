package com.repair.web.Controller.AE;

import com.repair.web.Entity.Admin;
import com.repair.web.Entity.Company;
import com.repair.web.Service.AE.AdminAEService;
import com.repair.web.Service.AE.WelcomeAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginAEController {
    private final AdminAEService adminAEService;
    private final WelcomeAEService welcomeAEService;

    public LoginAEController(AdminAEService adminAEService,WelcomeAEService welcomeAEService){this.adminAEService=adminAEService;
    this.welcomeAEService=welcomeAEService;}

    @RequestMapping(value = "/LoginAdmin",method = RequestMethod.GET)
    public String loginAdminPage(){
        return "LoginAdmin";
    }

    @RequestMapping(value = "/checkLoginAdmin",method = RequestMethod.POST)
    public ModelAndView  LoginAEPage(Admin admin){
        Map<String, String> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if(adminAEService.checkAdminLogin(admin.getAdmin_username(),admin.getAdmin_password())==null){
            modelAndView.setViewName("Error");
        }
        Admin temp=adminAEService.checkAdminLogin(admin.getAdmin_username(),admin.getAdmin_password());
        Company company=welcomeAEService.getCompanyInfo(temp.getAdmin_company());
        map.put("admin",temp.getAdmin_username());
        map.put("companyName",company.getCompany_name());
        map.put("address",company.getCompany_address());
        map.put("business",company.getCompany_business());
        map.put("info",company.getCompany_info());
        map.put("phone",company.getCompany_phone());
        map.put("time",company.getCompany_time().toString());
        modelAndView.setViewName("WelcomeBase");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
