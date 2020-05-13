package com.repair.web.Service.AE;

import com.repair.web.Dao.ItemsDao;
import com.repair.web.Entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsAEService {
    private final ItemsDao itemsDao;

    public ItemsAEService(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public List<Items>itemsForBase(String company){
        return itemsDao.itemsForBase(company);
    }

    public boolean borrowUpdate(String department,String items_id){
        return itemsDao.updateBorrow(items_id,department)>=1;
    }

    public Items getItemsInfo(String items_id){
        return itemsDao.getItemsInfo(items_id);
    }
}
