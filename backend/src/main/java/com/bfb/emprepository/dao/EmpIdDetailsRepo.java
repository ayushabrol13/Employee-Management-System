package com.bfb.emprepository.dao;

import com.bfb.emprepository.entities.EmpIdentityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpIdDetailsRepo extends JpaRepository<EmpIdentityDetails, Integer> {
}
