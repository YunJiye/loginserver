package com.example.loginserver.service.domain;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.loginserver.domain.userinfo.UserInfo;
import com.example.loginserver.domain.userinfo.UserInfoRepository;
import com.example.loginserver.dto.LoginFormDto;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author Admin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class UserInfoServiceImpl implements UserInfoService{

    private final UserInfoRepository userInfoRepository;

    @Override
    public Optional<UserInfo> findUserInfo(LoginFormDto loginFormDto) {
        return userInfoRepository.findByUseridAndUserpwd(loginFormDto.getId(), loginFormDto.getPw());
    }

}
