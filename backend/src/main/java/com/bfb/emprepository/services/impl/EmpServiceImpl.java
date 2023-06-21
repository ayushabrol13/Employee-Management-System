package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.exceptions.DatabaseEmptyException;
import com.bfb.emprepository.exceptions.InputFieldsEmptyException;
import com.bfb.emprepository.exceptions.ResourceNotFoundException;
import com.bfb.emprepository.entities.Employees;
import com.bfb.emprepository.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@CacheConfig(cacheNames = {"employees"})
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    @Cacheable(cacheNames = "employees")
    public Employees fetchEmployeeById(int eId) {
        return employeeRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", eId));
    }

    @Override
    @CachePut(cacheNames = "employees")
    public Employees replaceEmployee(Employees employee) {
        Employees existingEmp = new Employees();
        if(employee.getMail().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getEmpId()==0)
            throw new InputFieldsEmptyException();
        existingEmp.setEmpId(employee.getEmpId());
        existingEmp.setName(employee.getName());
        existingEmp.setSalary(employee.getSalary());
        existingEmp.setMail(employee.getMail());
        employeeRepo.save(existingEmp);
        return existingEmp;
    }

    @Override
    @CachePut(cacheNames = "employees")
    public Employees createEmployee(Employees employee) {
        if(employee.getMail().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getEmpId()==0)
            throw new InputFieldsEmptyException();
        return employeeRepo.save(employee);
    }

    @Override
    @CacheEvict(cacheNames = "employees", allEntries = true)
    public String deleteEmployee(int empId) {
        Employees existingEmp = employeeRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", empId));
        employeeRepo.delete(existingEmp);
        return "Employee with id " + empId + " got deleted successfully...";
    }

    @Override
    public List<Employees> fetchEmployees() {
        List<Employees> el= employeeRepo.findAll();
        if(el==null || el.size()==0)
            throw new DatabaseEmptyException();
        return el;
    }


    @Override
    public Employees updateEmployeeById(Integer eId, Employees employees) {
        Employees emp = employeeRepo.findById(eId).get();

        if(Objects.nonNull(employees.getName()) && !"".equalsIgnoreCase(employees.getName())){
            emp.setName(employees.getName());
        }
        if (Objects.nonNull(employees.getMail()) && !"".equalsIgnoreCase(employees.getMail())){
            emp.setMail(employees.getMail());
        }
        if (Objects.nonNull(employees.getSalary()) && !"".equalsIgnoreCase(employees.getSalary().toString())){
            emp.setSalary(employees.getSalary());
        }
        return employeeRepo.save(emp);
    }
}