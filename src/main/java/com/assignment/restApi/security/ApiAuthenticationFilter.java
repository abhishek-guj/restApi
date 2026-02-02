package com.assignment.restApi.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiAuthenticationFilter extends OncePerRequestFilter {
    @Value("${jwt_token}")
    String jwtToken;
    @Override
    @Bean
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String token = "";
        if(cookies==null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }
        for (Cookie cookie: cookies){
            if("access_token".equals(cookie.getName())){
                token=cookie.getValue();
            }
        }
        if(token == null || !token.equals(jwtToken)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }

        filterChain.doFilter(request,response);
    }
}
