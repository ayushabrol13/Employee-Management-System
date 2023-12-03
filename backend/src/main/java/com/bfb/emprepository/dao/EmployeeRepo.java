package com.bfb.emprepository.dao;

import com.bfb.emprepository.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Annotation for Repo layer
// transactional annotation is not required as JpaRepository has it by default
@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

    public Employees findByMailIgnoreCase(String mail);

}
