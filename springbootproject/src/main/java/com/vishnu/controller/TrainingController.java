package com.vishnu.controller;

import com.vishnu.model.Training;
import com.vishnu.service.TrainingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/27 0027.
 */
@Controller
public class TrainingController {
    @Resource
    private TrainingService trainingService;

    @RequestMapping("/toManageTra")
    public String toManageTra() throws Exception {
        return "manageTra";
    }

    @RequestMapping("/toAddTra")
    public String toAddTra() throws Exception {
        return "addTra";
    }

    @RequestMapping("/addTraServlet")
    public String addTraServlet(HttpServletRequest request) throws Exception {
        String name=request.getParameter("name");
        String text=request.getParameter("text");
        String address=request.getParameter("address");
        String startDateStr=request.getParameter("startDate");
        String endDateStr=request.getParameter("endDate");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate=null;
        try {
            startDate = sdf.parse(startDateStr);
            endDate=sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Training training=new Training(name,text,address,startDate,endDate);
        trainingService.addTraining(training);
        return toAddTra();
    }
}
