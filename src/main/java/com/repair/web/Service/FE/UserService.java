package com.repair.web.Service.FE;

import com.repair.web.Dao.UserDao;
import com.repair.web.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao=userDao;
    }

    public List<User> getUserInfo(String company,String department){
        return userDao.getUser(company,department);
    }

    public boolean restPassword(String id){
        String password="123456";
        return userDao.rest(password,id)>=1;
    }

    public boolean delUser(String id){
        return userDao.delOne(id)>=1;
    }

    public boolean addOne(User user){
        return userDao.register(user)>=1;
    }

    public User getMyUser(String username,String company,String department){
        return userDao.MyUser(company,department,username);
    }
}
