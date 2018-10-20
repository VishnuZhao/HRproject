package com.vishnu.dao;

import com.vishnu.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Mapper
public interface UserDao {
    void saveUser(User user);
    User getUserByNameAndPass(User user);
    User getUserById(int uid);
    User getUserByName(String name);
    void updateUser(User user);
    List<User> getAllUser();
}
