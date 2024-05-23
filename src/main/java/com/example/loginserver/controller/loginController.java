package com.example.loginserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/")
public class loginController {

    // connect to website
    @GetMapping("/main")
    public String connectToMainPage(){
        return "mainPage";
    }

    // connect to login page
    @GetMapping("/login")
    public String connectToLoginPage() {
        return "loginPage";
    }
    
}
