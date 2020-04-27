package com.repair.web.Controller.FE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.FE.DeviceService;
import com.repair.web.Service.FE.LoginService;
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

    public DeviceController(DeviceService deviceService,LoginService loginService){
        this.deviceService=deviceService;
        this.loginService=loginService;
    }

    @RequestMapping(value = "/GetDevice",method = RequestMethod.POST)
    public List<Device> getDevice(String device_id){
        return deviceService.getDeviceInfo(device_id);
    }

    @RequestMapping(value = "/DeviceInfo",method = RequestMethod.POST)
    public ModelAndView deviceInfo(String company){
        Map<String,List>map=new HashMap<>();
        map.put("DeviceList",deviceService.getCompanyDevices(company));
        map.put("company",loginService.SuperInfoList(company));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("DeviceInfo");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }
}
