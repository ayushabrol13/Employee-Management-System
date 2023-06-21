package com.bfb.emprepository.dao;

import com.bfb.emprepository.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepo extends JpaRepository<VerificationToken, Integer> {

    public VerificationToken findByToken(String token);
}
