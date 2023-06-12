package com.izibiz.api.utils;

import com.izibiz.service.enums.ErrorCode;
import com.izibiz.service.exception.CustomException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class JwtUtil {


    public Jws<Claims> decodeToken(String token, String secretKey) {
        Jws<Claims> claimsJws;
        try {
            claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            LocalDateTime currentDateTime = LocalDateTime.now();

            Instant issuedAtInstant = claimsJws.getBody().getIssuedAt().toInstant();

            LocalDateTime issuedAtDateTime = LocalDateTime.ofInstant(issuedAtInstant, ZoneId.systemDefault());

            if (issuedAtDateTime.isAfter(currentDateTime)) {
                throw new CustomException(("Token süresi dolmuştur , yeni bir token alınız."), ErrorCode.INVALID_TOKEN);
            }

        } catch (Exception e) {
            throw (new CustomException(("Bir sorun oluştu . Token içeriği değiştirilmiş olabilir. Yeni Token alınız."), ErrorCode.INVALID_TOKEN));
        }
        return claimsJws;
    }
}