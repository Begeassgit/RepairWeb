package com.repair.web.Controller.FE;

import com.repair.web.Entity.Order;
import com.repair.web.Service.FE.LoginService;
import com.repair.web.Service.FE.OrderService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public OrderController(OrderService orderService,LoginService loginService) {
        this.orderService = orderService;
        this.loginService=loginService;
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
        if(orderService.addOrder(order)){
            modelAndView.setViewName("");
            modelAndView.addObject("state",true);
        }
        else {
            modelAndView.setViewName("");
            modelAndView.addObject("state",false);
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

    @RequestMapping(value = "/DelOrder",method = RequestMethod.POST)
    public ModelAndView delOrder(String username,String department,String company,String order_id){
        ModelAndView modelAndView=new ModelAndView();
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


}
