package com.bfb.emprepository.controller;

import com.bfb.emprepository.entities.EmpIdentityDetails;
import com.bfb.emprepository.services.EmpIdDetailsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/identity")
@CrossOrigin("*")
public class EmpIdDetailsController {

    @Autowired
    private EmpIdDetailsSer ser;

    @PostMapping("")
    public EmpIdentityDetails createIdDetails(@RequestBody EmpIdentityDetails details) {
        return ser.createIdDetails(details);
    }

    @GetMapping("")
    public List<EmpIdentityDetails> fetchEmployeesIdDetails() {
        return ser.fetchEmployeesIdDetails();
    }

    @DeleteMapping("/{detailsId}")
    public String deleteEmpIdDetails(@PathVariable("detailsId") Integer detailsId) {
        ser.deleteEmpIdDetails(detailsId);
        return "Employee Identity Details with id "+ detailsId +"got deleted successfully...";
    }

    @GetMapping("/{eId}")
    public EmpIdentityDetails fetchEmpIdDetailsById(@PathVariable("eId") Integer id){
        return ser.fetchEmpIdDetailsById(id);
    }
    @PutMapping("")
    public EmpIdentityDetails updateEmpIdDetails(@RequestBody EmpIdentityDetails details) {
        return ser.createIdDetails(details);
    }
}
