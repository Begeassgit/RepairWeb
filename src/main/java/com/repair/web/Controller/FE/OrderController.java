package com.repair.web.Controller.FE;

import com.repair.web.Entity.Order;
import com.repair.web.Entity.User;
import com.repair.web.Entity.Worker;
import com.repair.web.Service.FE.LoginService;
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
public class OrderController {
    public final OrderService orderService;
    public final LoginService loginService;
    private final WorkerService workerService;

    public OrderController(OrderService orderService,LoginService loginService,WorkerService workerService) {
        this.orderService = orderService;
        this.loginService=loginService;
        this.workerService=workerService;
    }

    @RequestMapping(value = "/myOrder",method = RequestMethod.POST)
    public ModelAndView getMyOrder(String super_username, String order_company,String order_department){
        Map<String,List>map=new HashMap<>();
        map.put("List",orderService.getOrder(order_company,order_department));
        map.put("company",loginService.SuperInfoList(super_username,order_company,order_department));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("OrderInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/addOrderSubmit",method = RequestMethod.POST)
    public ModelAndView addOrder(Order order){
        ModelAndView modelAndView=new ModelAndView();
        if(!orderService.addOrder(order)){
            modelAndView.setViewName("Error");
        }
        else {
            User user1=new User();
            user1.setUser_username(order.getOrder_submitUser());
            user1.setUser_department(order.getOrder_department());
            user1.setUser_company(order.getOrder_company());
            modelAndView.setViewName("AddOrder");
            modelAndView.addObject("user",user1);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/pOrder",method = RequestMethod.POST)
    public ModelAndView pOrder(String order_id,String username,String order_company,String order_department){
        orderService.passOrder(order_id,order_department);
        Map<String,List>map=new HashMap<>();
        map.put("List",orderService.getOrder(order_company,order_department));
        map.put("company",loginService.SuperInfoList(username,order_company,order_department));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("OrderInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/dOrder",method = RequestMethod.POST)
    public ModelAndView dOrder(String order_id,String username,String order_company,String order_department){
        orderService.denyOrder(order_id,order_department);
        Map<String,List>map=new HashMap<>();
        map.put("List",orderService.getOrder(order_company,order_department));
        map.put("company",loginService.SuperInfoList(username,order_company,order_department));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("OrderInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelMyOrder",method = RequestMethod.POST)
    public ModelAndView delOrder(String username,String department,String company,String order_id){
        ModelAndView modelAndView=new ModelAndView();
        if(!orderService.delOneOrder(username, department, company, order_id)){
            modelAndView.setViewName("Error");
        }
        Map<String,List>map=new HashMap<>();
        List<String> list=new ArrayList<>();
        list.add(0,username);
        list.add(1,company);
        list.add(2,department);
        map.put("MyOrder",orderService.getMyOrder(company, department, username));
        map.put("username",list);
        modelAndView.setViewName("MyOrder");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/GetMyOrder",method = RequestMethod.POST)
    public ModelAndView myOrder(String username,String department,String company){
        Map<String,List>map=new HashMap<>();
        List<String> list=new ArrayList<>();
        list.add(0,username);
        list.add(1,company);
        list.add(2,department);
        map.put("MyOrder",orderService.getMyOrder(company, department, username));
        map.put("username",list);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("MyOrder");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/Deal",method = RequestMethod.POST)
    public ModelAndView dealOrder(String worker_name,String worker_id,String order_id,String order_department){
        ModelAndView modelAndView=new ModelAndView();
        if(!orderService.repOrder(order_id,order_department))
        {
            modelAndView.setViewName("Error");
        }
        Map<String, List> map=new HashMap<>();

        List<Worker> list=new ArrayList<>();
        list.add(0,workerService.getInfo(worker_id,worker_name));
        map.put("worker",list);
        map.put("order",orderService.getAll());
        modelAndView.setViewName("WorkerOrder");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @RequestMapping(value = "/ToSwitch",method = RequestMethod.POST)
    public ModelAndView switchOrder(String worker_name,String worker_id,String order_id,String order_department){
        ModelAndView modelAndView=new ModelAndView();
        if(!orderService.switchOrder(order_id,order_department)){
            modelAndView.setViewName("Error");
        }
        Map<String, List> map=new HashMap<>();

        List<Worker> list=new ArrayList<>();
        list.add(0,workerService.getInfo(worker_id,worker_name));
        map.put("worker",list);
        map.put("order",orderService.getAll());
        modelAndView.setViewName("WorkerOrder");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }

    @RequestMapping(value = "/Finish",method = RequestMethod.POST)
    public ModelAndView finish(String worker_name,String worker_id,String order_id,String order_department,String username,String company){
        ModelAndView modelAndView=new ModelAndView();
        if(!orderService.delOneOrder(username,order_department,company,order_id)){
            modelAndView.setViewName("Error");
        }
        Map<String, List> map=new HashMap<>();

        List<Worker> list=new ArrayList<>();
        list.add(0,workerService.getInfo(worker_id,worker_name));
        map.put("worker",list);
        map.put("order",orderService.getAll());
        modelAndView.setViewName("WorkerOrder");
        modelAndView.addAllObjects(map);

        return modelAndView;
    }



}
