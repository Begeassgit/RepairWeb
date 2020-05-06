package com.repair.web.Controller.AE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.AE.DeviceAEService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceAEController {
 /*   public final DeviceAEService deviceAEService;

    public DeviceAEController(DeviceAEService deviceAEService){
        this.deviceAEService=deviceAEService;
    }

    @RequestMapping(value = "/DeviceInfoAE",method = RequestMethod.GET)
    public String getDeviceInfoPage(){
        return "";
    }

    @ResponseBody
    @RequestMapping(value = "/FindDeviceInfoAE",method = RequestMethod.POST)
    public List<Device> findDeviceInfo(String deviceCompany){
        deviceCompany='%'+deviceCompany+'%';
        return deviceAEService.findDeviceInfo(deviceCompany);
    }*/

}
