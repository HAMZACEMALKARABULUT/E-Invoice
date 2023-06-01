package com.izibiz.api.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.izibiz.api.dto.Error;
import com.izibiz.api.dto.Response;
import com.izibiz.service.enums.ErrorCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomAccessDeniedException implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setStatus(403);
        Response<Void> response = Response.<Void>builder().error(new Error("geçersiz oturum", ErrorCode.INVALID_TOKEN.getErrorGroup().getCode())).build();
        resp.getWriter().write(new ObjectMapper().writeValueAsString(response));

    }
}
