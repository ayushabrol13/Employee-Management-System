package com.bfb.emprepository.dao;

import com.bfb.emprepository.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Annotation for Repo layer
@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
//    public List<Employees> findByDepartmentIgnoreCase(String dep);

    public Employees findByMailIgnoreCase(String mail);

}
