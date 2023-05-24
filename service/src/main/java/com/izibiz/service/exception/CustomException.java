package com.izibiz.service.exception;


import com.izibiz.service.enums.ErrorCode;

public class CustomException extends RuntimeException{

    private ErrorCode errorCode;
    public CustomException(String message,ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException(String message, Throwable cause,ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public CustomException(Throwable cause,ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
