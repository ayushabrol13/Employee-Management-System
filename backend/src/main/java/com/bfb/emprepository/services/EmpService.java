package com.bfb.emprepository.services;

import com.bfb.emprepository.entities.Employees;

import java.util.*;

public interface EmpService {

    public Employees createEmployee(Employees employee);
    public Employees fetchEmployeeById(int eId);
    public Employees updateEmployee(Employees employee);
    public String deleteEmployee(int empId);
    public List<Employees> fetchEmployees();

    public Employees updateEmployeeById(Integer eId, Employees employees);

    public void saveTokenForEmployee(String token, Employees employees);

    public String validateVerificationToken(String token);
}
