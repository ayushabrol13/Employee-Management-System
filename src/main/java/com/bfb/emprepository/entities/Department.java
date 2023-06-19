package com.bfb.emprepository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "dep_id")
    private Integer depId;
    @Column(name = "dep_name")
    private String depName;
    @Column(name = "designation")
    private String designation;

    @OneToMany (mappedBy = "department")
    @JsonIgnore
    private List<Employees> employees = new ArrayList<>();

}
