package com.vishnu.dao;

import com.vishnu.model.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public interface EmployeeDao {
    void addEmployee(Employee employee);
    void updateEmployeeByEmp(Employee employee);
    void updateEmployeeByAdmin(Employee employee);
    void deleteEmployee(int empid);
    Employee getEmployeeById(int empid);
    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByPosId(int posId);
    List<Employee> getEmployeeByDepId(int depId);
    Employee getEmployeeByNameAndUname(HashMap hashMap);
    List<Employee> getEmployeeByPosIdCorr(int posId);
}
