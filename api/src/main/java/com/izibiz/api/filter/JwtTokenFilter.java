package com.izibiz.api.filter;

import com.izibiz.api.context.Context;
import com.izibiz.api.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

public class JwtTokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userId = new String(Base64.getDecoder().decode(getUserToken((HttpServletRequest) servletRequest)));
       if(StringUtils.isNotBlank(userId) && StringUtils.isNumeric(userId)){
           RequestContext context = new RequestContext();
           context.setUserId(Long.parseLong(userId));
           Context.setCurrentUser(context);
       }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private String getUserToken(HttpServletRequest servletRequest){
        String authHeader = servletRequest.getHeader("Authorization");

        if(StringUtils.isBlank(authHeader)){
            return null;
        }
        return StringUtils.substringAfter(authHeader,"Bearer ");
    }
}