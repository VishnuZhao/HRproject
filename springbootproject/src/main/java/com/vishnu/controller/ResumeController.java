package com.vishnu.controller;

import com.vishnu.model.Resume;
import com.vishnu.model.User;
import com.vishnu.service.ResumeService;
import com.vishnu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/22 0022.
 */
@Controller
public class ResumeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/addResumeServlet")
    public String addResumeServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        Resume resume=new Resume(request.getParameter("name"),request.getParameter("sex"),request.getParameter("phone"),
                request.getParameter("education"),request.getParameter("school"),request.getParameter("major"),
                Integer.parseInt(request.getParameter("age")),0,Integer.parseInt(request.getParameter("workyear")),request.getParameter("introduction"),
                Integer.parseInt(request.getParameter("uid")),request.getParameter("rename"));
        if (resumeService.saveResume(resume)) {
            request.setAttribute("mess", "添加成功");
            return "addResume";
        } else {
            request.setAttribute("mess", "添加失败");
            return "addResume";
        }
    }

    @RequestMapping("/showResumeNameServlet")
    public String showResumeNameServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        List<Resume> resumes=resumeService.getResumeByUid(user.getU_id());
        List<Integer> resumeIds=new ArrayList<>();
        List<String> resumeNames=new ArrayList<>();
        for (Resume r:resumes) {
            resumeIds.add(r.getId());
            resumeNames.add(r.getRename());
        }
        session.setAttribute("resumeIds",resumeIds);
        session.setAttribute("resumeNames",resumeNames);
        return "showResumeName";
    }

    @RequestMapping("/toShowResume")
    public String toShowResume(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int re_id =Integer.parseInt(request.getParameter("re_id"));
        Resume resume=resumeService.getResumeById(re_id);
        if (resume==null){
            return "homePage";
        }
        session.setAttribute("resume",resume);
        return "showResume";
    }

    @RequestMapping("/toUpdateResume")
    public String toUpdateResume(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int re_id =Integer.parseInt(request.getParameter("re_id"));
        Resume resume=resumeService.getResumeById(re_id);
        if (resume==null){
            return "homePage";
        }
        session.setAttribute("resume",resume);
        return "updateResume";
    }

    @RequestMapping("/deleteResume")
    public String deleteResume(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int re_id =Integer.parseInt(request.getParameter("re_id"));
        resumeService.deleteResume(re_id);
        return showResumeNameServlet(request, response, session);
    }

    @RequestMapping("/updateResume")
    public String updateResume(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        Resume resume=new Resume(Integer.parseInt(request.getParameter("id")),request.getParameter("name"),request.getParameter("sex"),request.getParameter("phone"),
                request.getParameter("education"),request.getParameter("school"),request.getParameter("major"),
                Integer.parseInt(request.getParameter("age")),0,Integer.parseInt(request.getParameter("workyear")),request.getParameter("introduction"),
                Integer.parseInt(request.getParameter("uid")),request.getParameter("rename"));
        boolean res=resumeService.updateResume(resume);

        if (res){
            return showResumeNameServlet(request, response, session);
        }else {
            return "toUpdateResume";
        }
    }
}
