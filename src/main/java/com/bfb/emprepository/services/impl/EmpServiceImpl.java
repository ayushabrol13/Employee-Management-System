package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.exceptions.ResourceNotFoundException;
import com.bfb.emprepository.models.Employees;
import com.bfb.emprepository.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmpServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employees fetchEmployeeById(int eId) {
        return employeeRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", eId));
    }

    @Override
    public Employees updateEmployee(Employees emp) {
        Employees existingEmp = employeeRepo.findById(emp.getEmpId()).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", emp.getEmpId()));
        existingEmp.setId(emp.getId());
        existingEmp.setName(emp.getName());
        existingEmp.setSalary(emp.getSalary());
        existingEmp.setDepartment(emp.getDepartment());
        employeeRepo.save(existingEmp);
        return existingEmp;
    }

    @Override
    public Employees createEmployee(Employees employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public String deleteEmployee(int empId) {
        Employees existingEmp = employeeRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", empId));
        employeeRepo.delete(existingEmp);
        return "Employee with id " + empId + " got deleted successfully...";
    }

    @Override
    public List<Employees> fetchEmployees() {
        return employeeRepo.findAll();
    }
}
