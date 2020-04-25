package com.repair.web.Controller.FE;

import com.repair.web.Entity.Order;
import com.repair.web.Service.FE.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrderController {
    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/myOrder",method = RequestMethod.POST)
    public List<Order> getMyOrder(String order_company){
        return orderService.getOrder(order_company);
    }
}
