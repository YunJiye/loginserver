package com.example.loginserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlertMessageDto {
    private String message;
    private String redirectUrl;
}