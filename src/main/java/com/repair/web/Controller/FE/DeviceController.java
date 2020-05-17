package com.repair.web.Controller.FE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.FE.DeviceService;
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
public class DeviceController {
    public final DeviceService deviceService;
    public final LoginService loginService;
    public final OrderService orderService;

    public DeviceController(DeviceService deviceService,LoginService loginService,OrderService orderService){
        this.deviceService=deviceService;
        this.loginService=loginService;
        this.orderService=orderService;
    }

    @RequestMapping(value = "/GetDevice",method = RequestMethod.POST)
    public Device getDevice(String device_id){
        return deviceService.getDeviceInfo(device_id);
    }

    @RequestMapping(value = "/DeviceInfo",method = RequestMethod.POST)
    public ModelAndView deviceInfo(String username,String company,String department){
        Map<String,List>map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("DeviceInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/ItemsInfo",method = RequestMethod.POST)
    public ModelAndView ItemsInfo(String username,String company,String department){
        Map<String,List>map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("ItemsInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/DelDevice",method = RequestMethod.POST)
    public ModelAndView delDevice(String username,String company,String department,String device_id){
        ModelAndView modelAndView=new ModelAndView();
        if(!deviceService.returnDevice(device_id)){
            modelAndView.setViewName("Error");
            return modelAndView;
        }
        Map<String,List>map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company,department));
        map.put("ItemsList",deviceService.getCompanyItems(company,department));
        map.put("company",loginService.SuperInfoList(username,company,department));
        map.put("total",deviceService.getDeviceSum(company,department));
        map.put("status",orderService.getCountInfo(company,department));

        modelAndView.setViewName("DeviceInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/FindMyDevice",method = RequestMethod.POST)
    public ModelAndView findPage(String user_username,String user_company,String user_department){
        Map<String,String>map =new HashMap<>();
        map.put("company",user_company);
        map.put("department",user_department);
        map.put("username",user_username);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("InputDevice");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
