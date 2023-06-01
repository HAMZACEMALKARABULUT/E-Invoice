package com.izibiz.api.aspect;

import com.izibiz.api.dto.Response;
import com.izibiz.api.dto.Error;
import com.izibiz.service.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Response<Void>> handleCustomException(CustomException e) {
        Response<Void> response = Response.<Void>builder().error(new Error(e.getMessage(), e.getErrorCode().getErrorGroup().getCode())).build();
        return new ResponseEntity<Response<Void>>(response, e.getErrorCode().getErrorGroup().getHttpStatus());
    }

}
