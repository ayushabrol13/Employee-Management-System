package com.bfb.emprepository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeeData")
public class Employees {

    @Id
    private Integer empId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "salary")
    private Integer salary;

    @OneToOne(mappedBy = "employees")
    @JsonIgnore
    private EmpIdentityDetails identityDetails;

    @OneToOne(mappedBy = "employees")
    @JsonIgnore
    private EmpAddress empAddress;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;
}