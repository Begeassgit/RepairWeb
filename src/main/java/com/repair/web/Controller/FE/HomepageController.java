package com.repair.web.Controller.FE;

import com.repair.web.Service.FE.LoginService;
import org.springframework.stereotype.Controller;

@Controller
public class HomepageController {
    private final LoginService loginService;

    public HomepageController(LoginService loginService){
        this.loginService=loginService;
    }



}
