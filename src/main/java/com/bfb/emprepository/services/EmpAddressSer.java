package com.bfb.emprepository.services;

import com.bfb.emprepository.entities.EmpAddress;

import java.util.List;

public interface EmpAddressSer {

    public EmpAddress createEmpAddress(EmpAddress address);

    public List<EmpAddress> fetchAddresses();

    public void deleteEmpAddress(Integer addId);
}
