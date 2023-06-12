package com.bfb.emprepository.models;

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

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private Integer salary;


//    public Employees() {
//        super();
//    }
//
//    public Employees(Integer empId, String name, String department, Integer salary) {
//        super();
//        this.empId = empId;
//        this.name = name;
//        this.department = department;
//        this.salary = salary;
//    }
//
//    public Integer getEmpId() {
//        return empId;
//    }
//
//    public void setEmpId(Integer empId) {
//        this.empId = empId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public Integer getSalary() {
//        return salary;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public void setSalary(Integer salary) {
//        this.salary = salary;
//    }
}
