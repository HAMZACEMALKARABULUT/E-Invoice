package com.izibiz.api.filter;

import com.izibiz.api.context.Context;
import com.izibiz.api.context.RequestContext;
import com.izibiz.api.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenFilter extends GenericFilterBean {


    private final String jwtKey;

    public JwtTokenFilter(String jwtKey) {
        this.jwtKey = jwtKey;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        try {
            String token = getUserToken((HttpServletRequest) servletRequest);
            JwtUtil jwtUtil = new JwtUtil();
            Jws<Claims> claims;
            if (StringUtils.isNotBlank(token) && (claims = jwtUtil.decodeToken(token, jwtKey)) !=null ) {
                RequestContext context = new RequestContext();
                context.setUserId(claims.getBody().get("Id",Long.class));
                context.setUsername(claims.getBody().get("Mail",String.class));
                context.setRoles(claims.getBody().get("Roles", ArrayList.class));
                Context.setCurrentUser(context);
                List<String> roles = context.getRoles();
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(claims.getBody().getSubject(),null, roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            else {
                SecurityContextHolder.clearContext();
            }
        }catch (Exception e){
            SecurityContextHolder.clearContext();
        }
            try {
                filterChain.doFilter(servletRequest, servletResponse);
            }catch (Exception e){
                SecurityContextHolder.clearContext();
                //httpServletResponse.setStatus(403);
                //httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN,e.getMessage());
            }
    }

    private String getUserToken(HttpServletRequest servletRequest) {
        String authHeader = servletRequest.getHeader("Authorization");


        if (StringUtils.isBlank(authHeader)) {
            return null;
        }
        return StringUtils.substringAfter(authHeader, "Bearer ");
    }
}