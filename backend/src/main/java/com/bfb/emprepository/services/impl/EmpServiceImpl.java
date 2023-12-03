package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.dao.VerificationTokenRepo;
import com.bfb.emprepository.entities.VerificationToken;
import com.bfb.emprepository.exceptions.DatabaseEmptyException;
import com.bfb.emprepository.exceptions.InputFieldsEmptyException;
import com.bfb.emprepository.exceptions.ResourceNotFoundException;
import com.bfb.emprepository.entities.Employees;
import com.bfb.emprepository.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Integer.parseInt;

@Service
@CacheConfig(cacheNames = {"employees"})
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationTokenRepo verificationTokenRepo;

    @Override
    @Cacheable(cacheNames = "employees")
    public Employees fetchEmployeeById(int eId) {
        return employeeRepo.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", eId));
    }

    @Override
    @CachePut(cacheNames = "employees")
    public Employees updateEmployee(Employees employee) {
        Employees existingEmp = new Employees();
        if(employee.getMail().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("")|| employee.getPassword().equals(""))
            throw new InputFieldsEmptyException();
        existingEmp.setEmpId(employee.getEmpId());
        existingEmp.setName(employee.getName());
        existingEmp.setPassword(passwordEncoder.encode(employee.getPassword()));
        existingEmp.setMail(employee.getMail());
        employeeRepo.save(existingEmp);
        return existingEmp;
    }

    @Override
    @CachePut(cacheNames = "employees")
    public Employees createEmployee(Employees employee) {
        if(employee.getMail().equalsIgnoreCase("") || employee.getName().equalsIgnoreCase("") || employee.getPassword().equals(""))
            throw new InputFieldsEmptyException();
        Employees emp = new Employees();
        emp.setEmpId(employee.getEmpId());
        emp.setName(employee.getName());
        emp.setPassword(passwordEncoder.encode(employee.getPassword()));
        emp.setMail(employee.getMail());
        return employeeRepo.save(emp);
    }

    @Override
    @CacheEvict(cacheNames = "employees", allEntries = true)
    public String deleteEmployee(int empId) {
        Employees existingEmp = employeeRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", empId));
        employeeRepo.delete(existingEmp);
        return "Employee with id " + empId + " got deleted successfully...";
    }

    @Override
    public List<Employees> fetchEmployees() {
        List<Employees> el= employeeRepo.findAll();
        if(el==null || el.size()==0)
            throw new DatabaseEmptyException();
        return el;
    }


    @Override
    @CachePut(cacheNames = "employees", key = "#eId") //(eId needed or not)
    public Employees updateEmployeeById(Integer eId, Employees employees) {
        Employees emp = employeeRepo.findById(eId).get();

        if(Objects.nonNull(employees.getName()) && !"".equalsIgnoreCase(employees.getName())){
            emp.setName(employees.getName());
        }
        if (Objects.nonNull(employees.getMail()) && !"".equalsIgnoreCase(employees.getMail())){
            emp.setMail(employees.getMail());
        }
      
//        if (Objects.nonNull(employees.getPassword()) && !"".equalsIgnoreCase(employees.getPassword())){
//            emp.setPassword(employees.getPassword());
//        }
        return employeeRepo.save(emp);
    }

    @Override
    public void saveTokenForEmployee(String token, Employees employees) {
        VerificationToken verificationToken = new VerificationToken(employees, token);
        verificationTokenRepo.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepo.findByToken(token);
        if (verificationToken == null)
            return "invalid";
        Employees emp = verificationToken.getEmployee();
        Calendar cal = Calendar.getInstance();

        if(verificationToken.getExpirationTime().getTime() <= cal.getTime().getTime())
            return "The token got expired. Kindly, generate a new one...";

        emp.setEnabled(true);
        employeeRepo.save(emp);
        verificationTokenRepo.delete(verificationToken);
        return "valid";
    }

    //This is for UserDetailsService extended by EmpService for the Spring Security...
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return employeeRepo.findById(Integer.parseInt(username)).get();
   }
}
