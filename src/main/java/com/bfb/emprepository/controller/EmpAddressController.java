package com.bfb.emprepository.controller;

import com.bfb.emprepository.entities.EmpAddress;
import com.bfb.emprepository.services.EmpAddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class EmpAddressController {
    @Autowired
    private EmpAddressSer addressSer;

    @PostMapping("")
    public EmpAddress createEmpAddress(@RequestBody EmpAddress address) {
        return addressSer.createEmpAddress(address);
    }

    @GetMapping("")
    public List<EmpAddress> fetchAddresses(){
        return addressSer.fetchAddresses();
    }
}
