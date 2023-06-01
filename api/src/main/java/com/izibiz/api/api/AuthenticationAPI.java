package com.izibiz.api.api;

import com.izibiz.api.apiModel.LoginRequest;
import com.izibiz.api.dto.Response;
import com.izibiz.api.dto.TokenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/authentication")
public interface AuthenticationAPI {



        @PostMapping("/login")
        Response<TokenResponse> login(@RequestBody LoginRequest loginRequest);


}
