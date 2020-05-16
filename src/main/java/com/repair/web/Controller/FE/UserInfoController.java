package com.repair.web.Controller.FE;

import com.repair.web.Service.FE.DeviceService;
import com.repair.web.Service.FE.LoginService;
import com.repair.web.Service.FE.OrderService;
import com.repair.web.Service.FE.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInfoController {
    public final DeviceService deviceService;
    public final LoginService loginService;
    public final OrderService orderService;
    public final UserService userService;

    public UserInfoController(DeviceService deviceService,LoginService loginService,OrderService orderService,UserService userService){
        this.deviceService=deviceService;
        this.loginService=loginService;
        this.orderService=orderService;
        this.userService=userService;
    }

    @RequestMapping(value = "/UserInfo",method = RequestMethod.POST)
    public ModelAndView userInfo(String username,String company,String department){
        Map<String, List> map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));
        map.put("UserInfo",userService.getUserInfo(company,department));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("UserInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/RestUserPassword",method = RequestMethod.POST)
    public ModelAndView restUserPassword(String username,String company,String department,String id){
        ModelAndView modelAndView=new ModelAndView();
        if(!userService.restPassword(id)){
            modelAndView.setViewName("Error");
        }
        Map<String, List> map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));
        map.put("UserInfo",userService.getUserInfo(company,department));

        modelAndView.setViewName("UserInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelUser",method = RequestMethod.POST)
    public ModelAndView delUser(String username,String company,String department,String id){
        ModelAndView modelAndView=new ModelAndView();
        if(!userService.delUser(id)){
            modelAndView.setViewName("Error");
        }
        Map<String, List> map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));
        map.put("UserInfo",userService.getUserInfo(company,department));
        modelAndView.setViewName("UserInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/AddUser",method = RequestMethod.POST)
    public ModelAndView addUser(String username,String company,String department,String id){
        ModelAndView modelAndView=new ModelAndView();
        if(!userService.delUser(id)){
            modelAndView.setViewName("Error");
        }
        Map<String, List> map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));
        map.put("UserInfo",userService.getUserInfo(company,department));
        modelAndView.setViewName("UserInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }


}
