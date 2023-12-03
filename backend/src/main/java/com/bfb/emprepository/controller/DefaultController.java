package com.bfb.emprepository.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class DefaultController {
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hey there! Welcome to the Employee Management System made by Ayush Abrol...");
    }

    @RequestMapping("/signin")
    public String logInPage(){
        return "sign-in";
    }
}
