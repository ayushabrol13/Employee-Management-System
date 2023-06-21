package com.bfb.emprepository.controller;

import com.bfb.emprepository.entities.EmpAddress;
import com.bfb.emprepository.entities.EmpIdentityDetails;
import com.bfb.emprepository.services.EmpAddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/address")
public class EmpAddressController {
    @Autowired
    private EmpAddressSer addressSer;

    @PostMapping("")
    public EmpAddress createEmpAddress(@RequestBody EmpAddress address) {
        return addressSer.createEmpAddress(address);
    }

    @GetMapping("")
    public List<EmpAddress> fetchAddresses() {
        return addressSer.fetchAddresses();
    }

    @DeleteMapping("/{addId}")
    public String deleteEmpAddress(@PathVariable Integer addId){
        addressSer.deleteEmpAddress(addId);
        return "Address of the employee with address id "+ addId + "got deleted successfully...";
    }

    @GetMapping("/{eId}")
    public EmpAddress fetchEmpAddressById(@PathVariable("eId") Integer id){
        return addressSer.fetchEmpAddressById(id);
    }
}
