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
    @SequenceGenerator(
            name = "emp_id_seq",
            sequenceName = "emp_id_seq",
            allocationSize = 1,
            initialValue = 24600
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emp_id_seq"
    )
    private Integer empId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "employees", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private EmpIdentityDetails identityDetails;

    @OneToOne(mappedBy = "employees", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private EmpAddress empAddress;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dep_id")
    // CREATE INDEX idx_dep_name ON departments (dep_name);         must be used to create index for the dep_name column
    // ALTER TABLE employee_data ADD CONSTRAINT FK8r69vjcgsx66v01yspf79f2vh FOREIGN KEY (dep_name) REFERENCES departments (dep_name);
    private Department department;
}
