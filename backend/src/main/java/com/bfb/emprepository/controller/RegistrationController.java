package com.bfb.emprepository.controller;

import com.bfb.emprepository.entities.Employees;
import com.bfb.emprepository.events.RegistrationCompleteEvent;
import com.bfb.emprepository.services.EmpService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private EmpService empService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hey there! Welcome to the Employee Management System made by Brute Force Bandits...";
    }

    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employees employees, final HttpServletRequest request){
        empService.createEmployee(employees);
        publisher.publishEvent(new RegistrationCompleteEvent(
                employees,
                applicationUrl(request)
        ));
        return "Employee registered successfully. Please verify your email address from the link sent to your email id...";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = empService.validateVerificationToken(token);
        if(result.equalsIgnoreCase("valid"))
            return "Congrats! Employee got verified successfully...";
        return "Bad User!!!";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "https://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath();
    }

}
