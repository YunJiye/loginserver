package com.example.loginserver.dto;

import lombok.Setter;

import com.example.loginserver.domain.accountauth.AccountAuth;
import com.example.loginserver.domain.userinfo.UserInfo;

import lombok.Getter;

@Getter
@Setter
public class UserInfoDto {
    private String userid;
    private String userpwd;

    // domain에서 @build annotation으로 선언 후, 여기서 builder를 사용 가능.
    public UserInfo toEntity(){
        return UserInfo.builder()
                .userid(userid)
                .userpwd(userpwd)
                .build();
    }
}
