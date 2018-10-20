package com.vishnu.dao;

import com.vishnu.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Mapper
public interface UserDao {
    void saveUser(User user);
    User getUserByNameAndPass(User user);
    User getUserById(int uid);
    void updateUser(User user);

}
