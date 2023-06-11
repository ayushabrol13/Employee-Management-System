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

    @GetMapping("/employees/{eid}")
    public Employees fetchEmployee(@PathVariable("eid") int eId) {
        return empService.fetchDepartmentById(eId);
    }

    @PutMapping("/employees")
    public Employees updateEmployee(Employees emp) {
        return empService.updateEmployee(emp);
    }

    @DeleteMapping("/employees/{eid}")
    public String deleteEmployee(@PathVariable("eid") int empId){
        empService.deleteEmployee(empId);
        return "Employee with id " + empId + " got deleted successfully...";
    }
}
