package com.example.loginserver.service.checkauth;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.loginserver.domain.userinfo.UserInfo;
import com.example.loginserver.dto.LoginFormDto;
import com.example.loginserver.service.domain.UserInfoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckAuthServiceImpl implements CheckAuthService{

    private final UserInfoService userInfoService;

    /* 
     * loginFormDto에서 가져온 id, pw와 
     * userInfo 테이블의 데이터가 일치하는게 있으면 login 성공(true)!
     * 아니면 실패(false)를 리턴.
    */
    @Override
    public boolean checkAuth(final LoginFormDto loginFormDto) {
        final Optional<UserInfo> userInfo = userInfoService.findUserInfo(loginFormDto);
        return !userInfo.isEmpty();
    }
}