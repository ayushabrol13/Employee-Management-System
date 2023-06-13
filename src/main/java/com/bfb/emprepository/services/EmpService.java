package com.bfb.emprepository.services;

import com.bfb.emprepository.models.Employees;

import java.util.*;

public interface EmpService {

    public Employees createEmployee(Employees employee);
    public Employees fetchEmployeeById(int eId);
    public Employees replaceEmployee(Employees employee);
    public String deleteEmployee(int empId);
    public List<Employees> fetchEmployees();

    public List<Employees> fetchEmployeeByDepartment(String depName);

    public Employees updateEmployeeById(Integer eId, Employees employees);
}
