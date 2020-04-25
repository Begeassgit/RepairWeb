package com.repair.web.Controller.AE;

import com.repair.web.Entity.Admin;
import com.repair.web.Service.AE.AdminAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAEController {
    public final AdminAEService adminAEService;

    public LoginAEController(AdminAEService adminAEService){this.adminAEService=adminAEService;}

    @RequestMapping(value = "/LoginAdmin",method = RequestMethod.GET)
    public String loginAdminPage(){
        return "LoginAdmin.html";
    }

    @RequestMapping(value = "/checkLoginAdmin",method = RequestMethod.POST)
    public Admin LoginAEPage(Admin admin){
        return adminAEService.checkAdminLogin(admin.getAdmin_username(),admin.getAdmin_password());
    }
}
