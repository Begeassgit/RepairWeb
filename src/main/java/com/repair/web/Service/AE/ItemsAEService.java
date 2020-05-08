package com.repair.web.Service.AE;

import com.repair.web.Dao.ItemsDao;
import com.repair.web.Entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsAEService {
    public final ItemsDao itemsDao;

    public ItemsAEService(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public List<Items>itemsForBase(String company){
        return itemsDao.itemsForBase(company);
    }
}
