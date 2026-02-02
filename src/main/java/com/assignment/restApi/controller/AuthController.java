package com.assignment.restApi.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${jwt_token}")
    private String jwt_token;

    @PostMapping("sign-in")
    public ResponseEntity<Void> authenticateUser(HttpServletResponse response){
        Cookie cookie = new Cookie("access_token",jwt_token);

        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60*2); // unit type is seconds

        response.addCookie(cookie);
        return ResponseEntity.ok().build();
    }
}
