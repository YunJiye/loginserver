package com.example.loginserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.loginserver.domain.userinfo.UserInfo;
import com.example.loginserver.dto.UserInfoDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * user 정보를 컨트롤하는 컨트롤러이다.
 * 새로운 user가 회원가입할 경우, 그 정보를 db에 추가할 수 있도록 한다.
 */
@Slf4j
@Controller
@RequestMapping(value="/user")
@RequiredArgsConstructor
public class userController {

    // 회원 가입
    @GetMapping("/sign-up")
    public String signUpPage(Model model){
        model.addAttribute("userInfoDto", new UserInfoDto());
        return "signUpPage";
    }

    // 새 user 정보 db에 등록
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userInfoDto") UserInfoDto userInfoDto) {
        UserInfo userInfo = userInfoDto.toEntity();
        

        // 회원가입 처리 후 로그인 페이지로 이동
        return "redirect:/login";
    }
}
