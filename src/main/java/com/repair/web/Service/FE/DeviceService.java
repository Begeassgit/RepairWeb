package com.repair.web.Service.FE;

import com.repair.web.Dao.DeviceDao;
import com.repair.web.Entity.Device;
import org.springframework.stereotype.Service;

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
}
