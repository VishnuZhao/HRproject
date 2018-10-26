package com.vishnu.controller;

import com.vishnu.model.*;
import com.vishnu.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private MessageService messageService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping("/toAddEmp")
    public String toAdminPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int meid=Integer.parseInt(request.getParameter("meid"));
        Message message=messageService.getMessageById(meid);
        message.setStatus(3);
        messageService.updateMessage(message);
        int reid=Integer.parseInt(request.getParameter("reid"));
        Resume resume=resumeService.getResumeById(reid);
        List<Department> departments=departmentService.getAllDepartment();
        session.setAttribute("resume",resume);
        session.setAttribute("departments",departments);
        return "addEmployee";
    }

    @RequestMapping("/torefuseEmp")
    public String torefuseEmp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        int meid=Integer.parseInt(request.getParameter("meid"));
        Message message=messageService.getMessageById(meid);
        message.setStatus(4);
        messageService.updateMessage(message);
        return "refuseEmpSuccess";
    }


    @RequestMapping("/getPositionByDepName")
    @ResponseBody//加了此标签可以返回给ajax一个对象或者数组
    public List<Position> getPositionByDepName(HttpServletRequest request,String name) throws Exception {
        Department department=departmentService.getDepartmentByName(name);
        return positionService.getPositionByDepid(department.getId());
    }

    @RequestMapping("/addEmpServlet")
    public String addEmpServlet(HttpServletRequest request) throws Exception {
        String depName=request.getParameter("depName");
        String posName=request.getParameter("posName");
        double salary=Double.parseDouble(request.getParameter("salary"));
        Resume resume= (Resume) request.getSession().getAttribute("resume");
        Department department=departmentService.getDepartmentByName(depName);
        Position position=positionService.getPositionByNameAndDepid(posName,department.getId());
        Employee employee=new Employee(resume.getPhone(),"000000",resume.getSex(),resume.getPhone(),
                resume.getEducation(),resume.getSchool(),resume.getMajor(),department.getId(),position.getId(),
                salary,0);
        employeeService.addEmployee(employee);
        return "addEmployeeSuccess";
    }


    @RequestMapping("/toManageDepAndPos")
    public String toManageDepAndPos(HttpServletRequest request,String name) throws Exception {
        return "manageDepAndPos";
    }
}
