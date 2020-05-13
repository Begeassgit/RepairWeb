package com.repair.web.Service.AE;

import com.repair.web.Dao.TakeListDao;
import com.repair.web.Entity.TakeList;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TakeListAEService {
    private long count=0;
    private final TakeListDao takeListDao;


    public TakeListAEService(TakeListDao takeListDao){
        this.takeListDao=takeListDao;
    }

    public List<TakeList> getTakeList(String company){
        return takeListDao.getTakeList(company);
    }

    public boolean addTakeList(TakeList takeList){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMdd");
        Date date=new Date();
        String StrCount=String.format("%04d",count);
        takeList.setTake_list_time(date);
        takeList.setTake_list_list_id(simpleDateFormat.format(new Date())+StrCount);
        return takeListDao.addTakeList(takeList)>=1;
    }
}
