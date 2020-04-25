package com.repair.web.Service.FE;


import com.repair.web.Dao.SupervisorDao;
import com.repair.web.Dao.UserDao;
import com.repair.web.Entity.Supervisor;
import com.repair.web.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    public final UserDao userDao;
    public final SupervisorDao supervisorDao;

    public RegisterService(UserDao userDao,SupervisorDao supervisorDao){
        this.userDao=userDao;
        this.supervisorDao=supervisorDao;
    }

    public int registerUser(User user){
        return userDao.register(user);
    }

    public int registerSupervisor(Supervisor supervisor){
        return supervisorDao.register(supervisor);
    }

}
