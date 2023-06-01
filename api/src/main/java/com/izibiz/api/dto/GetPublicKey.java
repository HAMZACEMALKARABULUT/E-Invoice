package com.izibiz.api.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public@Data class GetPublicKey {
    @Value("${spring.security.oauth2.resourceserver.jwt.public-key}")
    private String jwtKey;


}
