package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmpIdDetailsRepo;
import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.entities.EmpIdentityDetails;
import com.bfb.emprepository.services.EmpIdDetailsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"empdetail"})
public class EmpIdDetailsSerImpl implements EmpIdDetailsSer {

    @Autowired
    private EmpIdDetailsRepo detailsRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    @CachePut(cacheNames = "empdetail")
    public EmpIdentityDetails createIdDetails(EmpIdentityDetails details) {
//        details.setEmployees(employeeRepo.getOne(details.get));
        return detailsRepo.save(details);
    }

    @Override
    public List<EmpIdentityDetails> fetchEmployeesIdDetails() {
        return detailsRepo.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "empdetail", allEntries = true)
    public void deleteEmpIdDetails(Integer detailsId) {
        detailsRepo.deleteById(detailsId);
    }

    @Override
    public EmpIdentityDetails fetchEmpIdDetailsById(Integer id) {
        EmpIdentityDetails details = detailsRepo.findById(id).get();
        return details;
    }

    @Override
    public EmpIdentityDetails updateEmployeeIdentity(EmpIdentityDetails details) {
        EmpIdentityDetails existingDetails = detailsRepo.findById(details.getEmpId()).orElse(null);
        existingDetails.setAadharNo(details.getAadharNo());
        existingDetails.setPanNo(details.getPanNo());
        existingDetails.setEmployees(details.getEmployees());
        return detailsRepo.save(existingDetails);
    }
}
