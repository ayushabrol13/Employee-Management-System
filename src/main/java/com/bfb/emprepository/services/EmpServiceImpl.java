package com.bfb.emprepository.services;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.models.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employees createEmployee(Employees employee) {
        return employeeRepo.save(employee);
    }


}
