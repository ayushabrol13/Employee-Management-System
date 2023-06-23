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
        return ResponseEntity.ok("Hey there! Welcome to the Employee Management System made by Brute Force Bandits...");
    }

    @RequestMapping("/signin")
    public String logInPage(){
//        String htmlContent = "<html><body><h1>Hello, World!</h1></body></html>";
//        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlContent);
        return "sign-in";
    }
}
