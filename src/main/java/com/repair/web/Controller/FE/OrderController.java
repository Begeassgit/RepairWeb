package com.repair.web.Controller.FE;

import com.repair.web.Entity.Order;
import com.repair.web.Service.FE.LoginService;
import com.repair.web.Service.FE.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getMyOrder(String order_company){
        Map<String,List>map=new HashMap<>();
        map.put("List",orderService.getOrder(order_company));
        map.put("company",loginService.SuperInfoList(order_company));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("OrderInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/addOrderSubmit",method = RequestMethod.POST)
    public ModelAndView addOrder(Order order){
        ModelAndView modelAndView=new ModelAndView();
        orderService.addOrder(order);
        modelAndView.setViewName("");
        return modelAndView;
    }
}
