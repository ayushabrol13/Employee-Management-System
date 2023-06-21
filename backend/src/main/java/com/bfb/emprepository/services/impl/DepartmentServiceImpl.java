package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.DepartmentRepo;
import com.bfb.emprepository.entities.Department;
import com.bfb.emprepository.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"departments"})
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    @CachePut(cacheNames = "departments")
    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    @CacheEvict(cacheNames = "departments", allEntries = true)
    public void deleteDepartment(Integer depName) {
//        Department dep = departmentRepo.findByDepNameIgnoreCase(depName);
        departmentRepo.deleteById(depName);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepo.findAll();
    }
}
