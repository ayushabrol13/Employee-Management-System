package com.bfb.emprepository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "empAddress")
public class EmpAddress {
    @Id
    @GeneratedValue
    private Integer addressId;
    private String localAddress;
    private String permanentAddress;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Employees employees;
}