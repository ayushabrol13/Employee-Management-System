package com.bfb.emprepository.dao;

import com.bfb.emprepository.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

    public List<Employees> findByDepartmentIgnoreCase(String depName);
}
