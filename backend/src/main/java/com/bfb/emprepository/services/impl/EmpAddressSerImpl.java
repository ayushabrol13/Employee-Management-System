package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmpAddressRepo;
import com.bfb.emprepository.entities.EmpAddress;
import com.bfb.emprepository.services.EmpAddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"address"})
public class EmpAddressSerImpl implements EmpAddressSer {

    @Autowired
    private EmpAddressRepo addressRepo;
    @Override
    @CachePut(cacheNames = "address")
    public EmpAddress createEmpAddress(EmpAddress address) {
        return addressRepo.save(address);
    }

    @Override
    public List<EmpAddress> fetchAddresses() {
        return addressRepo.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "address", allEntries = true)
    public void deleteEmpAddress(Integer addId) {
        addressRepo.deleteById(addId);
    }

    @Override
    public EmpAddress fetchEmpAddressById(Integer id) {
        return addressRepo.findById(id).get();
    }

    @Override
    public EmpAddress updateEmpAddress(EmpAddress address) {
        EmpAddress existingAddress = addressRepo.findById(address.getEmpId()).orElse(null);
        existingAddress.setLocalAddress(address.getLocalAddress());
        existingAddress.setPermanentAddress(address.getPermanentAddress());
        existingAddress.setEmployees(address.getEmployees());
        return addressRepo.save(existingAddress);
    }
}
