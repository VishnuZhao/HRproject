package com.vishnu.controller;


import com.vishnu.model.Department;
import com.vishnu.model.Employee;
import com.vishnu.model.Position;
import com.vishnu.service.DepartmentService;
import com.vishnu.service.EmployeeService;
import com.vishnu.service.PositionService;
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
public class PositionController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/toManagePos")
    public String toManageDepAndPos(HttpServletRequest request,String name) throws Exception {
        return "managePos";
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
            request.setAttribute("addPosition","添加成功");
            return "addPosition";
        }else {
            for (Position p:positions) {
                if (p.getName().equals(posName)){
                    request.setAttribute("addPosition","职位添加失败，该部门已有该职位");
                    return "addPosition";
                }
            }
            Date date=new Date();
            String time=date.toString();
            Position position=new Position(posName,department.getId(),time);
            positionService.addPosition(position);
            request.setAttribute("addPosition","添加成功");
            return "addPosition";
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
        List<Employee> employees=employeeService.getEmployeeByPosId(position.getId());
        if (employees==null || employees.size()==0){
            positionService.deletePosition(position.getId());
            request.setAttribute("deletePosition","部门删除成功");
            return "deletePosition";
        }
        request.setAttribute("deletePosition","部门删除失败，该部门有在职人员");
        return "deletePosition";
    }


    @RequestMapping("/toUpdatePosition")
    public String toUpdatePosition(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        List<Department> departments=departmentService.getAllDepartment();
        session.setAttribute("departments",departments);
        return "updatePosition";
    }

    @RequestMapping("/updatePositionServlet")
    public String updatePositionServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        String depName = request.getParameter("depName");
        String posName=request.getParameter("posName");
        Position position=positionService.getPositionByNameAndDepid(posName,departmentService.getDepartmentByName(depName).getId());
        String updateName =request.getParameter("updateName");
        position.setName(updateName);
        positionService.updatePosition(position);
        request.setAttribute("updatePosName","修改成功");
        return toUpdatePosition(request, response, session);
    }

}
