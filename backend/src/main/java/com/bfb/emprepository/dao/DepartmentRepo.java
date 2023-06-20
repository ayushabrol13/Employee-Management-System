package com.bfb.emprepository.dao;

import com.bfb.emprepository.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    public Department findByDepNameIgnoreCase(String dep);
}
