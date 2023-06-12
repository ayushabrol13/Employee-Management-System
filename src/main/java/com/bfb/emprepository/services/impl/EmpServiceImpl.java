package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.exceptions.DatabaseEmptyException;
import com.bfb.emprepository.exceptions.InputFieldsEmptyException;
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
    public Employees updateEmployee(Employees employee) {
        Employees existingEmp = employeeRepo.findById(employee.getEmpId()).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employee.getEmpId()));
        if(employee.getDepartment().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getEmpId()==0)
            throw new InputFieldsEmptyException();
        existingEmp.setName(employee.getName());
        existingEmp.setSalary(employee.getSalary());
        existingEmp.setDepartment(employee.getDepartment());
        employeeRepo.save(existingEmp);
        return existingEmp;
    }

    @Override
    public Employees createEmployee(Employees employee) {
        if(employee.getDepartment().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getEmpId()==0)
            throw new InputFieldsEmptyException();
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
        List<Employees> el= employeeRepo.findAll();
        if(el==null || el.size()==0)
            throw new DatabaseEmptyException();
        return el;
    }
}
