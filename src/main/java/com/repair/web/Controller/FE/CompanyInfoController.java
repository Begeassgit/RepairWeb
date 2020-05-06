package com.repair.web.Controller.FE;

import com.repair.web.Service.FE.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyInfoController {
   private final LoginService loginService;

   public CompanyInfoController(LoginService loginService){
       this.loginService=loginService;
   }

   @RequestMapping(value = "/ComInfo",method = RequestMethod.POST)
    public ModelAndView ComInfoPage(String super_username,String super_company,String super_department){
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.setViewName("ComInfo");
       modelAndView.addObject("super",loginService.SuperInfo(super_username,super_company,super_department));
       return modelAndView;
   }
}
