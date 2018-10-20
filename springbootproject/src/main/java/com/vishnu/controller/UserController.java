package com.vishnu.controller;

import com.vishnu.model.User;
import com.vishnu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/addUser")
    public boolean addUser(User user){
        boolean res=userService.saveUser(user);
        if (res){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/index")
    public String hello(Model model){
        return "index";
    }
}
