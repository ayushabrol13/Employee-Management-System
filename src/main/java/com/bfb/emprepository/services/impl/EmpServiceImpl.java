package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.exceptions.DatabaseEmptyException;
import com.bfb.emprepository.exceptions.InputFieldsEmptyException;
import com.bfb.emprepository.exceptions.ResourceNotFoundException;
import com.bfb.emprepository.models.Employees;
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

    public EmpServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    @Cacheable(cacheNames = "employees")
    public Employees fetchEmployeeById(int eId) {
        return employeeRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", eId));
    }

    @Override
    @CachePut(cacheNames = "employees")
    public Employees replaceEmployee(Employees employee) {
        try{
            Employees existingEmp = employeeRepo.findById(employee.getEmpId()).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employee.getEmpId()));
            if(employee.getDepartment().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getEmpId()==0)
                throw new InputFieldsEmptyException();
            existingEmp.setName(employee.getName());
            existingEmp.setSalary(employee.getSalary());
            existingEmp.setDepartment(employee.getDepartment());
            employeeRepo.save(existingEmp);
            return existingEmp;
        }
        catch (ResourceNotFoundException e){
            Employees newEmp = new Employees();
            newEmp.setEmpId(employee.getEmpId());
            newEmp.setName(employee.getName());
            newEmp.setSalary(employee.getSalary());
            newEmp.setDepartment(employee.getDepartment());
            return employeeRepo.save(newEmp);
        }
        catch (InputFieldsEmptyException e){
            throw new InputFieldsEmptyException();
        }
    }

    @Override
    @CachePut(cacheNames = "employees")
    public Employees createEmployee(Employees employee) {
        if(employee.getDepartment().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getEmpId()==0)
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
    public List<Employees> fetchEmployeeByDepartment(String depName) {
        return employeeRepo.findByDepartmentIgnoreCase(depName);
    }

    @Override
    public Employees updateEmployeeById(Integer eId, Employees employees) {
        Employees emp = employeeRepo.findById(eId).get();

        if(Objects.nonNull(employees.getName()) && !"".equalsIgnoreCase(employees.getName())){
            emp.setName(employees.getName());
        }
        if (Objects.nonNull(employees.getDepartment()) && !"".equalsIgnoreCase(employees.getDepartment())){
            emp.setDepartment(employees.getDepartment());
        }
        if (Objects.nonNull(employees.getSalary()) && !"".equalsIgnoreCase(employees.getSalary().toString())){
            emp.setSalary(employees.getSalary());
        }
        return employeeRepo.save(emp);
    }
}
