package com.example.loginserver.service.checkauth;

import org.springframework.stereotype.Service;

import com.example.loginserver.dto.LoginFormDto;

@Service
public interface CheckAuthService {
    public boolean checkAuth(LoginFormDto loginFormDto);
}