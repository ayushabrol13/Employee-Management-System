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

        if((employeeRepo.findByMailIgnoreCase("bfb@ninjacart.com")) == null) {
//            Department department = Department.builder()
//                    .depId(0)
//                    .depName("Paatal Lok")
//                    .designation("Cheeranjivi")
//                    .build();
//            departmentRepo.save(department);

            Employees employees = Employees.builder()
                    .empId(1430)
                    .name("Brute Force Bandits")
                    .mail("bfb@ninjacart.com")
                    .password(passwordEncoder.encode("admin"))
                    .role("ROLE_EMPLOYEE")
//                  .department(department)
                    .build();
            employeeRepo.save(employees);

//            EmpIdentityDetails empIdentityDetails = EmpIdentityDetails.builder()
//                    .detailsId(0)
//                    .aadharNo("123456789012")
//                    .panNo("1234567890")
//                    .employees(employees)
//                    .build();
//
//            EmpAddress address = EmpAddress.builder()
//                    .addressId(0)
//                    .localAddress("Heaven")
//                    .permanentAddress("Heaven Square")
//                    .employees(employees)
//                    .build();
//
//            idDetailsRepo.save(empIdentityDetails);
//            addressRepo.save(address);
        }
    }
}
