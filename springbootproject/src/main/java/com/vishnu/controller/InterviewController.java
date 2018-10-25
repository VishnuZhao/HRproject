package com.vishnu.controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.vishnu.model.*;
import com.vishnu.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Controller
public class InterviewController {
    @Resource
    private InterviewService interviewService;
    @Resource
    private MessageService messageService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private UserService userService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("/toWriteInterviewMess")
    public String toWriteInterviewMess(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int uid=Integer.parseInt(request.getParameter("uid"));
        int dvid=Integer.parseInt(request.getParameter("dvid"));
        Delivery delivery=deliveryService.getDeliveryById(dvid);
        Message message=new Message("您有一条面试邀请，请尽快处理",uid,0,2,0);
        session.setAttribute("message",message);
        session.setAttribute("delivery",delivery);
        return "writeInterviewMess";
    }

    @RequestMapping("/sendInterview")
    public String sendInterview(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String address=request.getParameter("address");
        String date=request.getParameter("date");
        String time=request.getParameter("time");
        date=date+" "+time;
        Message message= (Message) session.getAttribute("message");
        Delivery delivery= (Delivery) session.getAttribute("delivery");
        Interview interview=new Interview(address,date,delivery.getRe_id(),delivery.getRc_id(),0,0);
        boolean res=interviewService.addInterview(interview);
        Interview interview1=interviewService.getInterviewByOther(interview);

        message.setIt_id(interview1.getId());
        messageService.addMessage(message);
        Message message1=messageService.getMessageByItid(interview1.getId());
        interview1.setMess_id(message1.getId());
        interviewService.updateInterview(interview1);
        if (res) {
            delivery.setStatus(1);
            deliveryService.updateDelivery(delivery);
            return "sendInterviewSuccess";
        }
        return "adminPage";
    }

    @RequestMapping("/toShowMessage")
    public String toShowMessage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        List<Message> messages=messageService.getMessageByUid(user.getU_id());
        session.setAttribute("messages",messages);
        return "showMessage";
    }

    @RequestMapping("/toShowInterview")
    public String toShowInterview(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int meid=Integer.parseInt(request.getParameter("meid"));
        Message message=messageService.getMessageById(meid);
        if (message==null){
            return "homePage";
        }
        Interview interview=interviewService.getInterviewById(message.getIt_id());
        Recruit recruit=recruitService.getRecruitById(interview.getRc_id());
        session.setAttribute("interview",interview);
        session.setAttribute("recruit",recruit);
        return "showInterview";
    }

    @RequestMapping("/acceptInterview")
    public String acceptInterview(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int itid=Integer.parseInt(request.getParameter("itid"));
        Interview interview=interviewService.getInterviewById(itid);
        interview.setStatus(1);//修改interview=1：已接受的面试邀请
        interviewService.updateInterview(interview);
        Message message=messageService.getMessageByItid(interview.getId());
        message.setStatus(1);//修改message=1：已接受的面试邀请
        messageService.updateMessage(message);
        return "acceptInterviewSuccess";
    }

    @RequestMapping("/refuseInterview")
    public String refuseInterview(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        int itid=Integer.parseInt(request.getParameter("itid"));
        Interview interview=interviewService.getInterviewById(itid);
        interview.setStatus(2);//修改interview=2：已拒绝的面试邀请
        interviewService.updateInterview(interview);
        Message message=messageService.getMessageByItid(interview.getId());
        message.setStatus(2);//修改message=2：已拒绝的面试邀请
        messageService.updateMessage(message);
        return toShowMessage(request, response, session);
    }

    @RequestMapping("/toAcceptInterview")
    public String toAcceptInterview(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        /*User user= (User) session.getAttribute("user");
        if (user==null){
            return "login";
        }*/
        List<Message> messages=messageService.getMessageByAcceptInt();
        if (messages==null){
            return "adminPage";
        }
        List<User> users=new ArrayList<>();
        List<Recruit> recruits=new ArrayList<>();
        List<Resume> resumes=new ArrayList<>();
        for (Message me:messages) {
            users.add(userService.getUserById(me.getUid()));
            recruits.add(recruitService.getRecruitById(interviewService.getInterviewById(me.getIt_id()).getRc_id()));
            resumes.add(resumeService.getResumeById(interviewService.getInterviewById(me.getIt_id()).getRe_id()));
        }
        session.setAttribute("users",users);
        session.setAttribute("recruits",recruits);
        session.setAttribute("messages",messages);
        session.setAttribute("resumes",resumes);
        return "acceptInterview";
    }
}
