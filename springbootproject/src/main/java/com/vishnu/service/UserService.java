package com.vishnu.service;

import com.vishnu.model.User;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public interface UserService {
    boolean saveUser(User user);
    User getUserByNameAndPass(User user);
    User getUserById(int uid);
    boolean updateUser(User user);
}
