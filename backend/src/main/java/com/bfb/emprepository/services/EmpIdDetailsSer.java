package com.bfb.emprepository.services;

import com.bfb.emprepository.entities.EmpIdentityDetails;

import java.util.List;

public interface EmpIdDetailsSer {
    public EmpIdentityDetails createIdDetails(EmpIdentityDetails details);

    public List<EmpIdentityDetails> fetchEmployeesIdDetails();

    void deleteEmpIdDetails(Integer detailsId);
    public EmpIdentityDetails fetchEmpIdDetailsById(Integer id);

    public EmpIdentityDetails updateEmployeeIdentity(EmpIdentityDetails details);
}
