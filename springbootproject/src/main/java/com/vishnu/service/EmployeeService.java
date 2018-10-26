package com.vishnu.service;

import com.vishnu.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public interface EmployeeService {
    boolean addEmployee(Employee employee);
    boolean updateEmployeeByEmp(Employee employee);
    boolean updateEmployeeByAdmin(Employee employee);
    //boolean deleteEmployee(int empid);
    Employee getEmployeeById(int empid);
    List<Employee> getAllEmployee();
}
