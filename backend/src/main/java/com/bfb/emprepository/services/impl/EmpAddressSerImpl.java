package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmpAddressRepo;
import com.bfb.emprepository.entities.EmpAddress;
import com.bfb.emprepository.services.EmpAddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpAddressSerImpl implements EmpAddressSer {

    @Autowired
    private EmpAddressRepo addressRepo;
    @Override
    public EmpAddress createEmpAddress(EmpAddress address) {
        return addressRepo.save(address);
    }

    @Override
    public List<EmpAddress> fetchAddresses() {
        return addressRepo.findAll();
    }

    @Override
    public void deleteEmpAddress(Integer addId) {
        addressRepo.deleteById(addId);
    }

    @Override
    public EmpAddress fetchEmpAddressById(Integer id) {
        return addressRepo.findById(id).get();
    }
}
