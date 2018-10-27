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
import java.util.Date;
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


    @RequestMapping("/toManageEmp")
    public String toManageEmp(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        return "manageEmp";
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
        Date date=new Date();
        Employee employee=new Employee(resume.getPhone(),"000000",resume.getSex(),resume.getPhone(),
                resume.getEducation(),resume.getSchool(),resume.getMajor(),department.getId(),position.getId(),
                salary,0,resume.getUname(),date);
        employeeService.addEmployee(employee);
        return "addEmployeeSuccess";
    }

    @RequestMapping("/getEmpByPosName")
    @ResponseBody//加了此标签可以返回给ajax一个对象或者数组
    public List<Employee> getEmpByPosName(HttpServletRequest request,String name,String posName) throws Exception {
        Department department=departmentService.getDepartmentByName(name);
        Position position=positionService.getPositionByNameAndDepid(posName,department.getId());
        return employeeService.getEmployeeByPosId(position.getId());
    }

    @RequestMapping("/toDeleteEmp")
    public String toDeleteEmp(HttpServletRequest request) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        request.getSession().setAttribute("departments",departments);
        return "deleteEmp";
    }

    @RequestMapping("/deleteEmpServlet")
    public String deleteEmpServlet(HttpServletRequest request) throws Exception {
        String empInf=request.getParameter("empInf");
        String reason=request.getParameter("reason");
        String[] infs=empInf.split(":");
        String uname=infs[0];
        String name=infs[1];
        Employee employee=employeeService.getEmployeeByNameAndUname(name,uname);
        employee.setStatus(2);
        employee.setReason(reason);
        employeeService.updateEmployeeByAdmin(employee);
        request.setAttribute("deleteEmp","成功离职");
        return toDeleteEmp(request);
    }

    @RequestMapping("/toChangePosition")
    public String toChangePosition(HttpServletRequest request) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        request.getSession().setAttribute("departments",departments);
        return "changePosition";
    }

    @RequestMapping("/changePositionServlet")
    public String changePositionServlet(HttpServletRequest request) throws Exception {
        String empInf=request.getParameter("empInf");
        String[] infs=empInf.split(":");
        String uname=infs[0];
        String name=infs[1];
        Employee employee=employeeService.getEmployeeByNameAndUname(name,uname);
        request.getSession().setAttribute("employee",employee);
        return "afterChange";
    }

    @RequestMapping("/afterChangePosition")
    public String afterChangePosition(HttpServletRequest request) throws Exception {
        String depName = request.getParameter("depName");
        String posName=request.getParameter("posName");
        Double salary=Double.parseDouble(request.getParameter("salary"));
        Department department=departmentService.getDepartmentByName(depName);
        Position position=positionService.getPositionByNameAndDepid(posName,department.getId());
        Employee employee= (Employee) request.getSession().getAttribute("employee");
        employee.setDep_id(department.getId());
        employee.setPo_id(position.getId());
        employee.setSalary(salary);
        employee.setReason("工作调动");
        employeeService.updateEmployeeByAdmin(employee);
        request.getSession().setAttribute("employee",employee);
        return "changePositionSuccess";
    }

    @RequestMapping("/toCorrection")
    public String toCorrection(HttpServletRequest request) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        request.getSession().setAttribute("departments",departments);
        return "correction";
    }

    @RequestMapping("/getEmpByPosNameCorr")
    @ResponseBody//加了此标签可以返回给ajax一个对象或者数组
    public List<Employee> getEmpByPosNameCorr(HttpServletRequest request,String name,String posName) throws Exception {
        Department department=departmentService.getDepartmentByName(name);
        Position position=positionService.getPositionByNameAndDepid(posName,department.getId());
        return employeeService.getEmployeeByPosIdCorr(position.getId());
    }

    @RequestMapping("/correctEmp")
    public String correctEmp(HttpServletRequest request) throws Exception {
        String empInf=request.getParameter("empInf");
        String[] infs=empInf.split(":");
        String uname=infs[0];
        String name=infs[1];
        Employee employee=employeeService.getEmployeeByNameAndUname(name,uname);
        Date currDate=new Date();
        Date empDate=employee.getDate();
        long currDateTime=currDate.getTime();
        long empDateTime=empDate.getTime();
        if ((currDateTime-empDateTime)/1000/60/60/24<30){
            request.setAttribute("correctEmp","转正失败，该员工入职未满30天");
            return "correction";
        }
        employee.setStatus(1);
        employeeService.updateEmployeeByAdmin(employee);
        request.setAttribute("correctEmp","转正成功");
        return "correction";
    }
}
