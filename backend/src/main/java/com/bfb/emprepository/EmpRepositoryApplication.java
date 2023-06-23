package com.bfb.emprepository;

import com.bfb.emprepository.dao.DepartmentRepo;
import com.bfb.emprepository.dao.EmpAddressRepo;
import com.bfb.emprepository.dao.EmpIdDetailsRepo;
import com.bfb.emprepository.dao.EmployeeRepo;
import com.bfb.emprepository.entities.Department;
import com.bfb.emprepository.entities.EmpAddress;
import com.bfb.emprepository.entities.EmpIdentityDetails;
import com.bfb.emprepository.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories("com.bfb.emprepository.dao")
@EnableCaching
public class EmpRepositoryApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private EmpIdDetailsRepo idDetailsRepo;
    @Autowired
    private EmpAddressRepo addressRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(EmpRepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(employeeRepo.findByMailIgnoreCase("bfb@ninjacart.com").toString());
        Department d1 = new Department();
        if(departmentRepo.findByDesignation("SDE") == null) {
            d1 = Department.builder().depId(1).depName("Information Technology").designation("SDE").build();
            departmentRepo.save(d1);
            Department d2 = Department.builder().depId(2).depName("Information Technology").designation("Architect").build();
            departmentRepo.save(d2);
            Department d3 = Department.builder().depId(3).depName("Human Resource").designation("HR").build();
            departmentRepo.save(d3);
            Department d4 = Department.builder().depId(4).depName("Resource & Development").designation("R&D").build();
            departmentRepo.save(d4);
            Department d5 = Department.builder().depId(5).depName("Sales & Distribution").designation("S&D").build();
            departmentRepo.save(d5);
        }
        if((employeeRepo.findByMailIgnoreCase("bfb@ninjacart.com")) == null) {
            Employees employees = Employees.builder()
                    .empId(24600)
                    .name("Brute Force Bandits")
                    .mail("bfb@ninjacart.com")
                    .password(passwordEncoder.encode("admin"))
                    .role("ROLE_EMPLOYEE")
                    .enabled(true)
                    .department(d1)
                    .build();
            employeeRepo.save(employees);

            EmpIdentityDetails empIdentityDetails = EmpIdentityDetails.builder()
                    .empId(24600)
                    .aadharNo("123456789012")
                    .panNo("1234567890")
                    .build();

            EmpAddress address = EmpAddress.builder()
                    .empId(24600)
                    .localAddress("Heaven")
                    .permanentAddress("Heaven Square")
                    .build();

            idDetailsRepo.save(empIdentityDetails);
            addressRepo.save(address);
        }
    }
}
