package com.bfb.emprepository.services.impl;

import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Employees employee = employeeRepo.findByMailIgnoreCase(mail);

        if (employee == null)
            throw new UsernameNotFoundException("Employee not found...");

        HashSet<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole()));
        return new User(
                employee.getMail(),
                employee.getPassword(),
                employee.isEnabled(),
                true,
                true,
                true,
                authorities);
    }
}
