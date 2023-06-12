package com.bfb.emprepository.controller;

import com.bfb.emprepository.models.Employees;
import com.bfb.emprepository.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeesController {

    @Autowired
    private EmpService empService;


    @PostMapping("/employees")
    public Employees createEmployee(@RequestBody Employees employee) {
        return empService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employees> fetchEmployees() {
        return empService.fetchEmployees();
    }


    @GetMapping("/employees/{eId}")
    public Employees fetchEmployeeById(@PathVariable("eId") int eId) {
        return empService.fetchEmployeeById(eId);
    }

    @PutMapping("/employees")
    public Employees updateEmployee(@RequestBody Employees emp) {
        return empService.updateEmployee(emp);
    }

    @DeleteMapping("/employees/{eid}")
    public String deleteEmployee(@PathVariable("eid") int empId) {
        empService.deleteEmployee(empId);
        return "Employee with id " + empId + " got deleted successfully...";
    }

    @GetMapping("/employees/dep/{depName}")
    public List<Employees> fetchEmployeeByDepartment(@PathVariable("depName") String depName){
        return empService.fetchEmployeeByDepartment(depName);
    }
}
