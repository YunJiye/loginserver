package com.example.loginserver.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlertMessageDto {
    private String message;
    private String redirectUrl;
}