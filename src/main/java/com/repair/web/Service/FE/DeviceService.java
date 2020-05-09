package com.repair.web.Service.FE;

import com.repair.web.Dao.DeviceDao;
import com.repair.web.Dao.ItemsDao;
import com.repair.web.Entity.Device;
import com.repair.web.Entity.Items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {
    public final DeviceDao deviceDao;
    public final ItemsDao itemsDao;

    public DeviceService(DeviceDao deviceDao,ItemsDao itemsDao) {
        this.deviceDao = deviceDao;
        this.itemsDao=itemsDao;
    }

    public List<Device>getDeviceInfo(String device_id){
        return deviceDao.getDeviceInfo(device_id);
    }

    public List<Items>getCompanyItems(String device_company,String device_department){
        return itemsDao.getMyItems(device_company, device_department);
    }

    public List<Device>getCompanyDevices(String device_company,String device_department){
        return deviceDao.ComDeviceInfo(device_company,device_department);
    }

    public List<Integer>getDeviceSum(String device_company,String device_department){
        List<Integer> list=new ArrayList<>();
        list.add(0,deviceDao.getDeviceSum(device_company,device_department));
        return list;
    }

    public boolean returnDevice(String device_id){
        String device_department="";
        return deviceDao.returnDevice(device_department,device_id)>=1;
    }
}
