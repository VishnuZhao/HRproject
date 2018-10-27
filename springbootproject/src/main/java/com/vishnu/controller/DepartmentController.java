package com.vishnu.controller;


import com.vishnu.model.Department;
import com.vishnu.model.Position;
import com.vishnu.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
@Controller
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;

    @RequestMapping("/toManageDep")
    public String toManageDepAndPos(HttpServletRequest request,String name) throws Exception {
        return "manageDep";
    }

    @RequestMapping("/toAddDepartment")
    public String toAddDepartment(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        return "addDepartment";
    }

    @RequestMapping("/addDepartmentServlet")
    public String addDepartmentServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String name=request.getParameter("name");
        Department department1=departmentService.getDepartmentByName(name);
        if (department1!=null){
            request.setAttribute("addDepartment","添加失败，该部门已存在");
            return "addDepartment";
        }
        Date date=new Date();
        String time=date.toString();
        System.out.println(time);
        Department department=new Department(name,time);
        departmentService.addDepartment(department);
        return "addDepartmentSuccess";
    }

    @RequestMapping("/toDeleteDepartment")
    public String toDeleteDepartment(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        session.setAttribute("departments",departments);
        return "deleteDepartment";
    }

    @RequestMapping("/deleteDepServlet")
    public String deleteDepServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String depName =request.getParameter("depName");
        Department department=departmentService.getDepartmentByName(depName);
        List<Position> positions=positionService.getPositionByDepid(department.getId());
        if (positions==null || positions.size()==0){
            request.setAttribute("deleteDep","删除成功");
            boolean res=departmentService.deleteDepartment(department.getId());
            if (res){
                return toDeleteDepartment(request, response, session);
            }else {
                return "toDeleteDepartment";
            }
        }
        request.setAttribute("deleteDep","抱歉，该部门下有职位，请删除职位后重新操作");
        return "deleteDepartment";
    }

    @RequestMapping("/toShowDep")
    public String toShowDep(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        session.setAttribute("departments",departments);
        return "showDep";
    }

    @RequestMapping("/updateDepServlet")
    public String updateDepServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String depName =request.getParameter("depName");
        Department department=departmentService.getDepartmentByName(depName);
        String updateName =request.getParameter("updateName");
        department.setName(updateName);
        departmentService.updateDepartment(department);
        request.setAttribute("updateDepName","修改成功");
        return toShowDep(request, response, session);
    }
}
