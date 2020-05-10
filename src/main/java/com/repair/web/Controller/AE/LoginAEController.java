package com.repair.web.Controller.AE;

import com.repair.web.Entity.Admin;
import com.repair.web.Service.AE.AdminAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAEController {
    private final AdminAEService adminAEService;

    public LoginAEController(AdminAEService adminAEService){this.adminAEService=adminAEService;}

    @RequestMapping(value = "/LoginAdmin",method = RequestMethod.GET)
    public String loginAdminPage(){
        return "LoginAdmin";
    }

    @RequestMapping(value = "/checkLoginAdmin",method = RequestMethod.POST)
    public ModelAndView  LoginAEPage(Admin admin){
        ModelAndView modelAndView=new ModelAndView();
        if(adminAEService.checkAdminLogin(admin.getAdmin_username(),admin.getAdmin_password())==null){
            modelAndView.setViewName("Error");
        }
        Admin temp=adminAEService.checkAdminLogin(admin.getAdmin_username(),admin.getAdmin_password());
        modelAndView.setViewName("WelcomeBase");
        modelAndView.addObject("admin",temp);
        return modelAndView;
    }
}
