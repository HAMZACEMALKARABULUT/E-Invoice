package com.izibiz.service.enums;

import org.springframework.http.HttpStatus;

public enum ErrorGroup {

    BAD_REQUEST(10001, HttpStatus.BAD_REQUEST);
    private int code;
    private HttpStatus httpStatus;
    private ErrorGroup(int code,HttpStatus httpStatus){
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
