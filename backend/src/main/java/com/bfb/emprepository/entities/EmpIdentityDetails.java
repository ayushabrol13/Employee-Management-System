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
    @Column(name = "emp_id")
    private Integer empId;
    @Column(name = "aadhar_no", nullable = false, length = 12)
    private String aadharNo;
    @Column(name = "pan_no", nullable = false, length = 10)
    private String panNo;

    @OneToOne
//    @JoinColumn(name = "emp_id")
//    @JsonIgnore
    @PrimaryKeyJoinColumn(name = "emp_id")
    private Employees employees;
}
