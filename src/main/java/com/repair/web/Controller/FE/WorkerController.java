package com.repair.web.Controller.FE;

import com.repair.web.Entity.Worker;
import com.repair.web.Service.FE.OrderService;
import com.repair.web.Service.FE.WorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WorkerController {
    private final OrderService orderService;
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService,OrderService orderService){
        this.workerService=workerService;
        this.orderService=orderService;
    }


    @RequestMapping(value = "/WorkerLogin",method = RequestMethod.GET)
    public String workerLoginPage(){
        return "LoginWorker";
    }

    @RequestMapping(value = "/RegisterWorker",method = RequestMethod.GET)
    public String workerRegisterPage(){
        return "RegisterWorker";
    }

    @RequestMapping(value = "/WorkerSubmit",method = RequestMethod.POST)
    public ModelAndView login(String worker_id,String worker_password){
        Map<String, List> map=new HashMap<>();
        ModelAndView modelAndView=new ModelAndView();
        if(workerService.checkLoginService(worker_id,worker_password)==null){
            modelAndView.setViewName("Error");
        }
        List<Worker> list=new ArrayList<>();
        list.add(0,workerService.checkLoginService(worker_id, worker_password));
        map.put("worker",list);
        map.put("order",orderService.getAll());
        modelAndView.setViewName("WorkerOrder");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @RequestMapping(value = "/WorkerRegisterSubmit",method = RequestMethod.POST)
    public ModelAndView reg(Worker worker){
        ModelAndView modelAndView=new ModelAndView();
        if(!workerService.register(worker)){
           modelAndView.setViewName("Error");
        }
        modelAndView.setViewName("LoginWorker");
        return modelAndView;
    }
}
