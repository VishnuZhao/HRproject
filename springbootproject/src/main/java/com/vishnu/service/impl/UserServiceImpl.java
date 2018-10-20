package com.vishnu.service.impl;

import com.vishnu.dao.UserDao;
import com.vishnu.model.User;
import com.vishnu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public boolean saveUser(User user) {
        if (user==null || user.getU_name()==null || user.getU_pass()==null){
            return false;
        }
        userDao.saveUser(user);
        return true;
    }

    @Override
    public User getUserByNameAndPass(User user) {
        if (user==null){
            return null;
        }
        return userDao.getUserByNameAndPass(user);
    }

    @Override
    public User getUserById(int uid) {
        if (uid<10000){
            return null;
        }
        return userDao.getUserById(uid);
    }

    @Override
    public boolean updateUser(User user) {
        if (user==null){
            return false;
        }
        userDao.updateUser(user);
        return true;
    }
}
