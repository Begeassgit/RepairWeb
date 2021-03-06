package com.repair.web.Service.FE;

import com.repair.web.Dao.SupervisorDao;
import com.repair.web.Dao.UserDao;
import com.repair.web.Entity.Supervisor;
import com.repair.web.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    public final UserDao userDao;
    public final SupervisorDao supervisorDao;

    public LoginService(UserDao userDao, SupervisorDao supervisorDao) {
        this.userDao = userDao;
        this.supervisorDao = supervisorDao;
    }

    public User checkUserLogin(String username, String password){
       if(userDao.checkLogin(username,password)==null){
           return null;
       }
       return userDao.checkLogin(username,password);
    }

    public Supervisor checkSuperLogin(String username,String password){
        if(supervisorDao.checkSuperLogin(username,password)==null){
            return null;
        }
        return supervisorDao.checkSuperLogin(username,password);
    }

    public Supervisor SuperInfo(String username,String company,String department){
        return supervisorDao.superInfo(username,company,department);

    }

    public List<Supervisor> SuperInfoList(String username,String company,String department){

        List<Supervisor> list=new ArrayList<>();
        list.add(0,supervisorDao.superInfo(username,company,department));

        return list;
    }

}
