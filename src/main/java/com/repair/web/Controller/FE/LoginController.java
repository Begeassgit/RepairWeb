package com.repair.web.Controller.FE;

import com.repair.web.Entity.Supervisor;
import com.repair.web.Entity.User;
import com.repair.web.Service.FE.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LoginController {

    public final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    public String loginPage(){
        return "Login.html";
    }
    @RequestMapping(value = "/SupervisorLogin",method = RequestMethod.GET)
    public String supervisorLoginPage(){
        return "LoginSuper.html";
    }

    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public ModelAndView loginPage(User user){
        ModelAndView modelAndView=new ModelAndView();
        User temp=loginService.checkUserLogin(user.getUser_username(),user.getUser_password());
        if(temp==null)
        {
            modelAndView.setViewName("Login");
        }
        else {
            modelAndView.setViewName("");
            modelAndView.addObject("user",temp);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/checkSupervisorLogin",method = RequestMethod.POST)
    public ModelAndView superLogin(Supervisor supervisor){
        ModelAndView modelAndView=new ModelAndView();
        Supervisor temp= loginService.checkSuperLogin(supervisor.getSuper_username(),supervisor.getSuper_password());
        if(temp==null){
            modelAndView.setViewName("LoginSuper");
        }
        else{
            modelAndView.setViewName("ComInfo");
            modelAndView.addObject("super",temp);
        }
        return modelAndView;
    }
}
