package com.example.loginserver.domain.userinfo;

import com.example.loginserver.domain.base.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="USERINFO")
public class UserInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UNIQUEID")
    private Long uniqueid;

    @Column(name="USERID")
    private String userid;

    @Column(name="USERPWD")
    private String userpwd;

    @Builder
    public UserInfo(String userid, String userpwd){
        this.userid = userid;
        this.userpwd = userpwd;
    }
}
