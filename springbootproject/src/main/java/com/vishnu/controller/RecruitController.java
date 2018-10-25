package com.vishnu.controller;

import com.vishnu.model.Delivery;
import com.vishnu.model.Resume;
import com.vishnu.model.User;
import com.vishnu.service.RecruitService;
import com.vishnu.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Controller
public class RecruitController {
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("/toChooseResume")
    public String chooseResume(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int rc_id=Integer.parseInt(request.getParameter("rc_id"));
        List<Resume> resumes=resumeService.getResumeByUid(user.getU_id());
        if (resumes==null){
            return "addResume";
        }
        session.setAttribute("rc_id",rc_id);
        session.setAttribute("resumes",resumes);
        return "chooseResume";
    }

}
