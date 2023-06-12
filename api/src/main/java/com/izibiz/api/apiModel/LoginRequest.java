package com.izibiz.api.apiModel;

import lombok.Data;

public @Data class LoginRequest {

    private String userName;
    private String password;

    public LoginRequest(){}

    public LoginRequest(String userName,String password){

        this.userName=userName;
        this.password=password;
    }
}
