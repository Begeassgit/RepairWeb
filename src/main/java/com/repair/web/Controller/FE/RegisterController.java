package com.repair.web.Controller.FE;

import com.repair.web.Entity.Supervisor;
import com.repair.web.Entity.User;
import com.repair.web.Service.FE.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    public final RegisterService registerService;

    public RegisterController(RegisterService registerService){
        this.registerService=registerService;
    }

    @RequestMapping(value = "/RegisterSuper",method = RequestMethod.GET)
    public String registerSuperPage(){
        return "RegisterSuper";
    }

    @RequestMapping(value = "/submitUser",method = RequestMethod.POST)
    public String finishSubmit(User user){
        if(registerService.registerUser(user)>=1){
            return "Login";
        }
        else {
            return "Error";
        }
    }

    @RequestMapping(value = "/submitSuper",method = RequestMethod.POST)
    public String finishSubmitSuper(Supervisor supervisor){
        if(registerService.registerSupervisor(supervisor)>=1){
            return "LoginSuper";
        }
        else    {
            return "Error";
        }
    }
}
