package com.vishnu.service.impl;

import com.vishnu.dao.EmployeeDao;
import com.vishnu.model.Employee;
import com.vishnu.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee==null){
            return false;
        }
        employeeDao.addEmployee(employee);
        return true;
    }

    @Override
    public boolean updateEmployeeByEmp(Employee employee) {
        if (employee==null){
            return false;
        }
        employeeDao.updateEmployeeByEmp(employee);
        return true;
    }

    @Override
    public boolean updateEmployeeByAdmin(Employee employee) {
        if (employee==null){
            return false;
        }
        employeeDao.updateEmployeeByAdmin(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(int empid) {
        if (empid<10000){
            return null;
        }
        return employeeDao.getEmployeeById(empid);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public List<Employee> getEmployeeByPosId(int posId) {
        if (posId<10000){
            return null;
        }
        return employeeDao.getEmployeeByPosId(posId);
    }

    @Override
    public List<Employee> getEmployeeByDepId(int depId) {
        if (depId<10000){
            return null;
        }
        return employeeDao.getEmployeeByDepId(depId);
    }

    @Override
    public Employee getEmployeeByNameAndUname(String name, String uname) {
        if (name==null || uname==null){
            return null;
        }
        HashMap<String,String> map=new HashMap<>();
        map.put("name",name);
        map.put("uname",uname);
        return employeeDao.getEmployeeByNameAndUname(map);
    }

    @Override
    public List<Employee> getEmployeeByPosIdCorr(int posId) {
        if (posId<10000){
            return null;
        }
        return employeeDao.getEmployeeByPosIdCorr(posId);
    }
}
