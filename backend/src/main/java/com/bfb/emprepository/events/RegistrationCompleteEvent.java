package com.bfb.emprepository.events;

import com.bfb.emprepository.entities.Employees;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter @Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private Employees employees;
    private String applicationUrl;
    public RegistrationCompleteEvent(Employees employees, String applicationUrl) {
        super(employees);
        this.employees = employees;
        this.applicationUrl = applicationUrl;
    }

    public RegistrationCompleteEvent(Employees employees, Clock clock) {
        super(employees, clock);
    }
}
