package com.repair.web.Controller.FE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.FE.DeviceService;
import com.repair.web.Service.FE.LoginService;
import com.repair.web.Service.FE.OrderService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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

    @RequestMapping(value = "/FindSubmit",method = RequestMethod.POST)
    public ModelAndView findSubmit(String device_id,String device_name,String device_brand,String device_type,
                                   String device_department,String device_company,String username){
        ModelAndView modelAndView=new ModelAndView();
        List<String> list=new ArrayList();
        list.add(0,username);
        list.add(1,device_company);
        list.add(2,device_department);
        Map<String,List>map=new HashMap<>();
        Device device=new Device();
        device.setDevice_id(device_id);
        device.setDevice_name(device_name);
        device.setDevice_brand(device_brand);
        device.setDevice_type(device_type);
        device.setDevice_department(device_department);
        device.setDevice_company(device_company);
        map.put("Result",deviceService.findDevice(device));
        map.put("user",list);
        modelAndView.setViewName("DeviceResult");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @RequestMapping(value = "/AddSubmit",method = RequestMethod.POST)
    public ModelAndView addOrder(String device_id,String device_name,String device_brand,String device_type,
                                 String device_department,String device_company,String username){
        ModelAndView modelAndView=new ModelAndView();
        List<String> list=new ArrayList();
        list.add(0,username);
        list.add(1,device_company);
        list.add(2,device_department);
        Map<String,List>map=new HashMap<>();
        Device device=new Device();
        device.setDevice_id(device_id);
        device.setDevice_name(device_name);
        device.setDevice_brand(device_brand);
        device.setDevice_type(device_type);
        device.setDevice_department(device_department);
        device.setDevice_company(device_company);
        map.put("Result",deviceService.findDevice(device));
        map.put("user",list);
        modelAndView.setViewName("DeviceResult");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
