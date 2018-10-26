package com.vishnu.service.impl;

import com.vishnu.dao.DepartmentDao;
import com.vishnu.model.Department;
import com.vishnu.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;
    @Override
    public boolean addDepartment(Department department) {
        if (department==null){
            return false;
        }
        departmentDao.addDepartment(department);
        return true;
    }

    @Override
    public boolean deleteDepartment(int dep_id) {
        if (dep_id<10000){
            return false;
        }
        departmentDao.deleteDepartment(dep_id);
        return true;
    }

    @Override
    public boolean updateDepartment(Department department) {
        if (department==null){
            return false;
        }
        departmentDao.updateDepartment(department);
        return true;
    }

    @Override
    public Department getDepartmentById(int dep_id) {
        if (dep_id<10000){
            return null;
        }
        return departmentDao.getDepartmentById(dep_id);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public Department getDepartmentByName(String name) {
        if (name==null){
            return null;
        }
        return departmentDao.getDepartmentByName(name);
    }
}
