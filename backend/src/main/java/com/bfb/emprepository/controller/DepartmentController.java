package com.bfb.emprepository.controller;

import com.bfb.emprepository.entities.Department;
import com.bfb.emprepository.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/departments")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public Department createDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("")
    public List<Department>fetchDepartments(){
         return departmentService.fetchDepartments();
    }

    @DeleteMapping("/{depId}")
    public String deleteDepartment(@PathVariable("depId") Integer depId) {
        departmentService.deleteDepartment(depId);
        return "Department with id, " + depId + " got deleted successfully...";
    }

//    @DeleteMapping("/{depName}")
//    public String deleteDepartment(@PathVariable("depName") String depName) {
//        departmentService.deleteDepartment(depName);
//        return "Department, " + depName + " got deleted successfully...";
//    }
}
