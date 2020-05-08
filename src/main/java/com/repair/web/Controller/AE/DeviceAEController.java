package com.repair.web.Controller.AE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.AE.DeviceAEService;
import com.repair.web.Service.AE.ItemsAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceAEController {
 public final DeviceAEService deviceAEService;
 public final ItemsAEService itemsAEService;

    public DeviceAEController(DeviceAEService deviceAEService,ItemsAEService itemsAEService){
        this.deviceAEService=deviceAEService;
        this.itemsAEService=itemsAEService;
    }

    @RequestMapping(value = "/DeviceInfoAE",method = RequestMethod.GET)
    public String getDeviceInfoPage(){
        return "";
    }

    @RequestMapping(value = "/FindDeviceInfoAE",method = RequestMethod.POST)
    public List<Device> findDeviceInfo(String deviceCompany){
        deviceCompany='%'+deviceCompany+'%';
        return deviceAEService.findDeviceInfo(deviceCompany);
    }

    @RequestMapping(value = "/Admin/Base",method = RequestMethod.POST)
    public ModelAndView basePage(String company){
        Map<String,List> map=new HashMap<>();
        map.put("device",deviceAEService.companyBase(company));
        map.put("items",itemsAEService.itemsForBase(company));
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("Base");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

}
