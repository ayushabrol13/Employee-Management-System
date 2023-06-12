package com.bfb.emprepository.dao;

import com.bfb.emprepository.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
    public List<Employees> findByDepartmentIgnoreCase(String depName);
}
