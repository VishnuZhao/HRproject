package com.vishnu.dao;

import com.vishnu.model.Department;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public interface DepartmentDao {
    void addDepartment(Department department);
    void deleteDepartment(int dep_id);
    void updateDepartment(Department department);
    Department getDepartmentById(int dep_id);
    List<Department> getAllDepartment();
}
