package com.example.loginserver.dto;

import lombok.Setter;
import com.example.loginserver.domain.accountauth.AccountAuth;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class AccountAuthDto {
    private String authtype;

    // domain에서 @build annotation으로 선언 후, 여기서 builder를 사용 가능.
    public AccountAuth toEntity(){
        return AccountAuth.builder()
                .authtype(authtype)
                .build();
    }

}
