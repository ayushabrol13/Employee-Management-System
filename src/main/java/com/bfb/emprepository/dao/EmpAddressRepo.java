package com.bfb.emprepository.dao;

import com.bfb.emprepository.entities.EmpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpAddressRepo extends JpaRepository<EmpAddress, Integer> {
}
