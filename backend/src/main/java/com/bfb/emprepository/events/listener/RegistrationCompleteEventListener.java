package com.bfb.emprepository.events.listener;

import com.bfb.emprepository.entities.Employees;
import com.bfb.emprepository.events.RegistrationCompleteEvent;
import com.bfb.emprepository.services.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private EmpService empService;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create Verification Token for the Employee with Link...
        Employees employees = event.getEmployees();
        String token = UUID.randomUUID().toString();
        empService.saveTokenForEmployee(token, employees);

        // Send Mail to the employee to verify the registration, here it is done via Console.
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;

        // Sending verification link on the console...
        log.info("Click the link to verify your account: \n {}", url);
    }
}
