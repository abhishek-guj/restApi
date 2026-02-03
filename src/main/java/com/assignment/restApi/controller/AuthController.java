package com.assignment.restApi.controller;

import com.assignment.restApi.security.JWTUtil;
import com.assignment.restApi.utils.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Value("${jwt_token}")
    private String jwt_token;


    @PostMapping("sign-in")
    public ResponseEntity<Void> authenticateUser(HttpServletResponse response){

        response.addCookie(CookieUtil.createCookie(jwt_token));
        return ResponseEntity.ok().build();
    }
}
