package com.repair.web.Controller.FE;

import com.repair.web.Service.FE.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
    private final LoginService loginService;

    public HomepageController(LoginService loginService){
        this.loginService=loginService;
    }

    @RequestMapping(value = "/Home",method = RequestMethod.POST)
    public ModelAndView homePage(String user,String user_department,String user_company){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("AddOrder");
        return modelAndView;
    }

}
