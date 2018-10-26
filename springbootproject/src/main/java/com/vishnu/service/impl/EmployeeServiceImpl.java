package com.vishnu.service.impl;

import com.vishnu.dao.EmployeeDao;
import com.vishnu.model.Employee;
import com.vishnu.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
