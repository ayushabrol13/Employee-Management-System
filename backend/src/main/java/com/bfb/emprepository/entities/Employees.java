package com.bfb.emprepository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employeeData")
public class Employees {

    @Id
    @SequenceGenerator(name = "emp_id_seq", sequenceName = "emp_id_seq", allocationSize = 1, initialValue = 24600)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_id_seq")
    private Integer empId;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "mail", unique = true)
    private String mail;
    @Column(name = "password", length = 60)
    private String password;
    private boolean enabled = false;
    @Column(name = "role", nullable = true)
    private String role;

    @PrePersist
    @PreUpdate
    private void calculateRole(){
        String domain = mail.split("@")[1];
        if(domain.equalsIgnoreCase("gmail.com"))
            this.role = "ADMIN";
        else
            this.role = "EMPLOYEE";
    }

// Entities Relations...
    @OneToOne(mappedBy = "employees", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private EmpIdentityDetails identityDetails;

    @OneToOne(mappedBy = "employees", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private EmpAddress empAddress;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private VerificationToken verificationToken;
}
