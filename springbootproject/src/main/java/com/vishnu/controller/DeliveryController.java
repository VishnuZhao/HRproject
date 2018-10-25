package com.vishnu.controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.vishnu.model.Delivery;
import com.vishnu.model.Resume;
import com.vishnu.model.User;
import com.vishnu.service.DeliveryService;
import com.vishnu.service.RecruitService;
import com.vishnu.service.ResumeService;
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
public class DeliveryController {
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("/sendRecruit")//发送职位
    public String sendRecruit(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        int re_id=Integer.parseInt(request.getParameter("re_id"));
        int rc_id= (int) session.getAttribute("rc_id");
        Delivery delivery=new Delivery(re_id,rc_id,0);
        deliveryService.addDelivery(delivery);
        return "sendResumeSuccess";
    }

    @RequestMapping("/toShowDelivery")
    public String toShowDelivery(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        List<Delivery> deliveries=deliveryService.getAllDelivery();
        if (deliveries==null){
            return "adminPage";
        }
        List<String> userNames=new ArrayList<>();
        List<String> rc_names=new ArrayList<>();
        List<Integer> uids=new ArrayList<>();
        for (Delivery d:deliveries) {
            rc_names.add(recruitService.getRecruitById(d.getRc_id()).getName());
            userNames.add(resumeService.getResumeById(d.getRe_id()).getUname());
            uids.add(resumeService.getResumeById(d.getRe_id()).getUid());
        }
        session.setAttribute("deliveries",deliveries);
        session.setAttribute("userNames",userNames);
        session.setAttribute("rc_names",rc_names);
        session.setAttribute("uids",uids);
        return "showDelivery";
    }

    @RequestMapping("/toAdminPage")
    public String toAdminPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
       return "adminPage";
    }

    @RequestMapping("/refuseInterviewByAdmin")
    public String refuseInterviewByAdmin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int dvid=Integer.parseInt(request.getParameter("dvid"));
        Delivery delivery=deliveryService.getDeliveryById(dvid);
        delivery.setStatus(1);
        deliveryService.updateDelivery(delivery);
        return toShowDelivery(request, response, session);
    }
}
