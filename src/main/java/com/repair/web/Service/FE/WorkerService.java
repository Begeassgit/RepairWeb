package com.repair.web.Service.FE;

import com.repair.web.Dao.WorkerDao;
import com.repair.web.Entity.Worker;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerDao workerDao;

    public WorkerService(WorkerDao workerDao){
        this.workerDao=workerDao;
    }

    public Worker checkLoginService(String worker_id,String worker_password){
        return workerDao.checkLogin(worker_id,worker_password);
    }

    public Worker getInfo(String worker_id,String worker_name){
        return workerDao.getInfo(worker_id,worker_name);
    }

    public boolean register(Worker worker){
        return workerDao.add(worker)>=1;
    }
}
