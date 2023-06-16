package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmpIdDetailsRepo;
import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.entities.EmpIdentityDetails;
import com.bfb.emprepository.services.EmpIdDetailsSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpIdDetailsSerImpl implements EmpIdDetailsSer {

    @Autowired
    private EmpIdDetailsRepo detailsRepo;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmpIdentityDetails createIdDetails(EmpIdentityDetails details) {
//        details.setEmployees(employeeRepo.getOne(details.get));
        return detailsRepo.save(details);
    }

    @Override
    public List<EmpIdentityDetails> fetchEmployeesIdDetails() {
        return detailsRepo.findAll();
    }
}
