package com.izibiz.api.controller;

import com.izibiz.api.api.AuthenticationAPI;
import com.izibiz.api.apiModel.LoginRequest;
import com.izibiz.api.dto.Response;
import com.izibiz.api.dto.TokenResponse;
import com.izibiz.service.domain.Role;
import com.izibiz.service.domain.User;
import com.izibiz.service.enums.ErrorCode;
import com.izibiz.service.exception.CustomException;
import com.izibiz.service.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class AuthenticationController implements AuthenticationAPI {

    @Value("${spring.security.oauth2.resourceserver.jwt.public-key}")
    private String jwtKey;
    @Autowired
    private UserService userService;


    public Optional<User> loginControl(String userName, String password) {
        Optional<User> user = userService.findUserBymail(userName);
        if (user.isPresent() && userService.userAuthentication(user.get(), password)) {
            return user;
        } else {
            throw (new CustomException(("Giriş başarısız"), ErrorCode.RECORD_NOT_FOUND));
        }
    }

    @Override
    public Response<TokenResponse> login(LoginRequest loginRequest) {
        Optional<User> user = loginControl(loginRequest.getUserName(), loginRequest.getPassword());
        if (user.isPresent()) {
            return Response.<TokenResponse>builder().data(generateToken(user.get())).build();
        } else {
            throw (new CustomException(("Giriş başarısız"), ErrorCode.RECORD_NOT_FOUND));

        }
    }

    public TokenResponse generateToken(User user) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, 1);


        TokenResponse tokenResponse = new TokenResponse();
        List<String> roleList = new ArrayList<>();
        for (Role role : user.getRole()
        ) {
            roleList.add(role.getRoleName());
        }
        tokenResponse.setRoles(roleList);




        String token = Jwts.builder()

                .setSubject(user.getMail())
                .claim("Mail", user.getMail())
                .claim("Id", user.getId())
                .claim("Name", user.getName())
                .claim("Surname", user.getSurname())
                .claim("Roles", tokenResponse.getRoles())
                .setExpiration(calendar.getTime())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,jwtKey)
                .compact();


        tokenResponse.setToken(token);
        tokenResponse.setExpireDate(calendar.getTime());
        tokenResponse.setUserName(user.getMail());
        tokenResponse.setUserId(user.getId());
        tokenResponse.setName(user.getName());
        tokenResponse.setSurname(user.getSurname());


        return tokenResponse;
    }


}
