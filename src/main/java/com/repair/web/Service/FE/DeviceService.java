package com.repair.web.Service.FE;

import com.repair.web.Dao.DeviceDao;
import com.repair.web.Entity.Device;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    public final DeviceDao deviceDao;

    public DeviceService(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    public List<Device>getDeviceInfo(String device_id){
        return deviceDao.getDeviceInfo(device_id);
    }

    public List<Device>getCompanyDevices(String device_company){
        return deviceDao.ComDeviceInfo(device_company);
    }

    public List<Integer>getDeviceSum(String device_company){
        List<Integer> list=new ArrayList<>();
        list.add(0,deviceDao.getDeviceSum(device_company));
        System.out.printf("");
        return list;
    }
}
