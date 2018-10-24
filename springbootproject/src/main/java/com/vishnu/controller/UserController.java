package com.vishnu.controller;

import com.vishnu.model.Recruit;
import com.vishnu.model.Resume;
import com.vishnu.model.User;
import com.vishnu.service.RecruitService;
import com.vishnu.service.ResumeService;
import com.vishnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RecruitService recruitService;

    @RequestMapping("/index")
    public String hello(Model model,HttpSession session){
        List<Recruit> recruits = recruitService.getRecruitByPage(1,3);
        System.out.println(recruits);
        session.setAttribute("recruits",recruits);
        return "index";
    }

    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public String register(){
        return "register";
    }

    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(){
        return "updateUser";
    }

    @RequestMapping("/toHomePage")
    public String toHomePage(){
        return "homePage";
    }

    @RequestMapping("/toAddResume")
    public String toAddResume(){
        return "addResume";
    }

    @RequestMapping("/showResume")
    public String showResume(){
        return "showResume";
    }

    @RequestMapping("/addUserServlet")
    public String addUser(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user1=userService.getUserByName(request.getParameter("name"));
        if(user1==null){
            User user = new User(request.getParameter("name"),request.getParameter("pass"));
            if (userService.saveUser(user)){
                request.setAttribute("msg","注册成功");
                return "login";
            }else{
                request.setAttribute("msg","注册失败");
                return "register";
            }
        }else{
            request.setAttribute("msg","注册失败,该用户名已经存在");
            return "register";
        }
    }

    @RequestMapping(value = "/loginServlet")
    public String loginServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {

        if (request.getParameter("name").equals("888") & request.getParameter("pass").equals("888")) {
            return "adminpage";
        }
        User user = new User(request.getParameter("name"), request.getParameter("pass"));
        String log = request.getParameter("log");
        if (userService.getUserByNameAndPass(user) != null) {
                session.setAttribute("name", user.getU_name());
                session.setAttribute("uid", userService.getUserByNameAndPass(user).getU_id());
                session.setAttribute("user", userService.getUserByNameAndPass(user));
                if ("on".equals(log)) {
                    Cookie cookie = new Cookie("name", user.getU_name());
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                }
            session.setAttribute("msg", user.getU_name()+"登陆成功");
            return "homePage";
        } else {
            session.setAttribute("msg", "null");
            return "login";
        }
    }
    @RequestMapping("/autoLogin")
    public String autoLogin (HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Cookie[] cookies = request.getCookies();
        List<User> users = userService.getAllUser();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            for (User user : users) {
                if (name.equals("name") && value.equals(user.getU_name())) {
                    request.getSession().setAttribute("name", user.getU_name());
                    request.getSession().setAttribute("uid", user.getU_id());
                    request.getSession().setAttribute("user", user);
                    session.setAttribute("msg", user.getU_name()+"登陆成功");
                    return "homePage";
                }
            }
            session.setAttribute("msg", "null");
        }
        return "login";
    }
    @RequestMapping("/updateUserServlet")
    public String updateUser(HttpServletRequest request,HttpServletResponse response)throws Exception {
        User user=new User(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("pass"));
        boolean res=userService.updateUser(user);
        User user1=userService.getUserById(Integer.parseInt(request.getParameter("id")));
        if (res){
            request.getSession().setAttribute("user",user1);
            return "homePage";
        }else{
            return "updateUser";
        }
    }


}
