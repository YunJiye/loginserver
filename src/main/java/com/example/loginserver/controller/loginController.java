package com.example.loginserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.loginserver.dto.LoginFormDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    public String connectToLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginFormDto());
        return "loginPage";
    }

    // submit login information
    @PostMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginFormDto loginFormDto){
        log.info("loginFormDto : id={}, pw={}", loginFormDto.getId(), loginFormDto.getPw());
        return "testThymeleaf";
    }
    
}
