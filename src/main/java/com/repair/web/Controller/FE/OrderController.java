package com.repair.web.Controller.FE;

import com.repair.web.Entity.Order;
import com.repair.web.Service.FE.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderController {
    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/myOrder",method = RequestMethod.POST)
    public ModelAndView getMyOrder(String order_company){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("OrderInfo");
        modelAndView.addObject("List",orderService.getOrder(order_company));
        return modelAndView;
    }
}
