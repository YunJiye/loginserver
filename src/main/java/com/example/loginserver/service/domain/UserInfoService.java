package com.example.loginserver.service.domain;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.loginserver.domain.userinfo.UserInfo;
import com.example.loginserver.dto.LoginFormDto;

@Service
public interface UserInfoService {
    public Optional<UserInfo> findUserInfo(LoginFormDto loginFormDto);
}