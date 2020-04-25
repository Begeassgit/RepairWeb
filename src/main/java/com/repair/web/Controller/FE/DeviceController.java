package com.repair.web.Controller.FE;

import com.repair.web.Entity.Device;
import com.repair.web.Service.FE.DeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DeviceController {
    public final DeviceService deviceService;

    public DeviceController(DeviceService deviceService){
        this.deviceService=deviceService;
    }

    @RequestMapping(value = "/GetDevice",method = RequestMethod.POST)
    public List<Device> getDevice(String device_id){
        return deviceService.getDeviceInfo(device_id);
    }
}
