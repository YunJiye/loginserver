package com.example.loginserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginserver.dto.AlertMessageDto;
import com.example.loginserver.dto.LoginFormDto;
import com.example.loginserver.service.checkauth.CheckAuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/")
@RequiredArgsConstructor
public class loginController {

    private final CheckAuthService checkAuthService;

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
    public String loginForm(@ModelAttribute("loginForm") LoginFormDto loginFormDto, Model model){
        log.info("loginFormDto : id={}, pw={}", loginFormDto.getId(), loginFormDto.getPw());
        // 로그인 성공
        if(checkAuthService.checkAuth(loginFormDto)){
            log.info("login success");
            return "testThymeleaf";
        }
        // 로그인 실패
        else{
            log.info("login fail");
            AlertMessageDto msg = new AlertMessageDto();
            msg.setMessage("로그인 실패! 아이디나 비밀번호를 확인해주세요.");
            msg.setRedirectUrl("/login");
            return alertLoginFail(msg, model);
        }
    }

    // alert for login failure and redirect
    private String alertLoginFail(AlertMessageDto msg, Model model) {
        model.addAttribute("alertMessage", msg);
        return "alertMessageRedirect";
    }
 
}
