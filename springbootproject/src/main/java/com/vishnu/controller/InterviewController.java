package com.vishnu.controller;

import com.vishnu.model.*;
import com.vishnu.service.DeliveryService;
import com.vishnu.service.InterviewService;
import com.vishnu.service.MessageService;
import com.vishnu.service.RecruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/toWriteInterviewMess")
    public String toWriteInterviewMess(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int uid=Integer.parseInt(request.getParameter("uid"));
        int dvid=Integer.parseInt(request.getParameter("dvid"));
        Delivery delivery=deliveryService.getDeliveryById(dvid);
        Message message=new Message("您有一条面试邀请，请尽快处理",uid,0,2,0);
        messageService.addMessage(message);
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
        Interview interview=new Interview(address,date,delivery.getRe_id(),delivery.getRc_id(),message.getId());
        boolean res=interviewService.addInterview(interview);
        //Interview interview1=interviewService.getInterviewByMessId(message.getId());
        Interview interview1=interviewService.getInterviewByOther(interview);

        message.setIt_id(interview1.getId());
        messageService.updateMessage(message);
        Message message1=messageService.getMessageByItid(interview1.getId());
        System.out.println(message);
        System.out.println(message1);
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

}
