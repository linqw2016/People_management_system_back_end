package org.linqw.vhr.service;

import org.linqw.vhr.mapper.DepartmentMapper;
import org.linqw.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);

    }

    public void deleteDepById(Department department) {
        departmentMapper.deleteDepById(department);
    }

    public List<Department> getAllDepartmentsWithoutChildren() {
        return departmentMapper.getAllDepartmentsWithoutChildren();
    }
}
