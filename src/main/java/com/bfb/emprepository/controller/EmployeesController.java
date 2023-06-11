package com.bfb.emprepository.controller;

import com.bfb.emprepository.customKey.CustomKeyGenerator;
import com.bfb.emprepository.models.Employees;
import com.bfb.emprepository.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//cache config
@CacheConfig(cacheNames = {"employees"})
public class EmployeesController {

    @Autowired
    private EmpService empService;

//    @Autowired
//    private CustomKeyGenerator customKeyGenerator;

    @PostMapping("/employees")
    public Employees createEmployee(@RequestBody Employees employee) {
        return empService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employees> fetchEmployees() {
        return empService.fetchEmployees();
    }

    @GetMapping("/employees/{eid}")
    @Cacheable(key = "#eid")
    public Employees fetchEmployee(@PathVariable("eid") int eId) {
        return empService.fetchDepartmentById(eId);
    }

    @PutMapping("/employees")
    @CachePut
    public Employees updateEmployee(Employees emp) {
        return empService.updateEmployee(emp);
    }

    @DeleteMapping("/employees/{eid}")
    @CacheEvict(key = "#eid", allEntries = true)
    public String deleteEmployee(@PathVariable("eid") int empId){
        empService.deleteEmployee(empId);
        return "Employee with id " + empId + " got deleted successfully...";
    }
}
