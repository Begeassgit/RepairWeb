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

    public boolean borrowUpdate(String department,String items_id,int num){
        int last=itemsDao.getItemsInfo(items_id).getItems_count()-num;
        return itemsDao.updateBorrow(items_id,department,last)>=1;
    }

    public Items getItemsInfo(String items_id){
        return itemsDao.getItemsInfo(items_id);
    }

    public boolean addOneItems(Items items){
        return itemsDao.addItems(items)>=1;
    }
}
