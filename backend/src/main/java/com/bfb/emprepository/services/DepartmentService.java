package com.bfb.emprepository.services;

import com.bfb.emprepository.entities.Department;

import java.util.List;

public interface DepartmentService {

    public Department createDepartment(Department department);

    public void deleteDepartment(Integer depId);

    public List<Department> fetchDepartments();
}
