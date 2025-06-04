package com.yathu.spring_boot_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {
    @GetMapping("/")
    public String getHomePage(){
        return "Welcome to the Home Page!";
    }

    @GetMapping("/dashboard")
    public String getDashboardPage() {
        return "Login Successful Welcome to the Dashboard!";
    }


    }



