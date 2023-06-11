package com.bfb.emprepository.models;

import javax.persistence.*;

@Entity
@Table(name = "employeeData")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;


    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private Integer salary;

    public Employees() {
        super();
    }

    public Employees(Integer empId, Integer id, String name, String department, Integer salary) {
        super();
        this.empId = empId;
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
