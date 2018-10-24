package com.vishnu.service;

import com.vishnu.model.Department;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean deleteDepartment(int dep_id);
    boolean updateDepartment(Department department);
    Department getDepartmentById(int dep_id);
    List<Department> getAllDepartment();
}
