package com.izibiz.api.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

public @Data class TokenResponse {
    private String token;
    private Date expireDate;
    private String userName;

    private String name;

    private String surname;

    private Long userId;

    private List<String> roles;
}
