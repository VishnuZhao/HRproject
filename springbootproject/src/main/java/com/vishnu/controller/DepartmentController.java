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

    @RequestMapping("/toAddDepartment")
    public String toAddDepartment(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        return "addDepartment";
    }

    @RequestMapping("/addDepartmentServlet")
    public String addDepartmentServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String name=request.getParameter("name");
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
            session.setAttribute("deleteDepFail",null);
            boolean res=departmentService.deleteDepartment(department.getId());
            if (res){
                return "deleteDepSuccess";
            }else {
                return "toDeleteDepartment";
            }
        }
        session.setAttribute("deleteDepFail","抱歉，该部门下有职位，请删除职位后重新操作");
        return "deleteDepartment";
    }

    @RequestMapping("/toAddPosition")
    public String toAddPosition(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        session.setAttribute("departments",departments);
        return "addPosition";
    }

    @RequestMapping("/addPositionServlet")
    public String addPositionServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String depName = request.getParameter("depName");
        String posName=request.getParameter("posName");
        Department department = departmentService.getDepartmentByName(depName);
        List<Position> positions=positionService.getPositionByDepid(department.getId());
        if (positions==null || positions.size()==0){
            Date date=new Date();
            String time=date.toString();
            Position position=new Position(posName,department.getId(),time);
            positionService.addPosition(position);
            return toAddPosition(request, response, session);
        }else {
            for (Position p:positions) {
                if (p.getName().equals(posName)){
                    session.setAttribute("addPositionFail","职位添加失败，该部门已有该职位");
                    return "addPosition";
                }
            }
            Date date=new Date();
            String time=date.toString();
            Position position=new Position(posName,department.getId(),time);
            positionService.addPosition(position);
            return toAddPosition(request, response, session);
        }
    }

    @RequestMapping("/toDeletePosition")
    public String toDeletePosition(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        session.setAttribute("departments",departments);
        return "deletePosition";
    }

    @RequestMapping("/deletePositionServlet")
    public String deletePositionServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String depName = request.getParameter("depName");
        String posName=request.getParameter("posName");
        Position position=positionService.getPositionByNameAndDepid(posName,departmentService.getDepartmentByName(depName).getId());
        positionService.deletePosition(position.getId());
        return "deletePosition";
    }

}
