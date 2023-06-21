package com.bfb.emprepository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
@Table(name = "emp_identity_details")
public class EmpIdentityDetails {
    @Id
    @GeneratedValue
    @Column(name = "details_id")
    private Integer detailsId;
    @Column(name = "aadhar_no", nullable = false, length = 12, unique = true)
    private String aadharNo;
    @Column(name = "pan_no", nullable = false, length = 10, unique = true)
    private String panNo;

    @OneToOne
    @JoinColumn(name = "emp_id")
//    @JsonIgnore
    private Employees employees;
}
