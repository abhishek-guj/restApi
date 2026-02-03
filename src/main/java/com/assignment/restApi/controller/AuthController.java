package com.assignment.restApi.controller;

<<<<<<< HEAD
=======
import com.assignment.restApi.security.JWTUtil;
import com.assignment.restApi.utils.CookieUtil;
>>>>>>> ccac54b (new project)
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/auth")
=======
@RequestMapping("/api/v1/auth")
>>>>>>> ccac54b (new project)
public class AuthController {

    @Value("${jwt_token}")
    private String jwt_token;

<<<<<<< HEAD
    @PostMapping("sign-in")
    public ResponseEntity<Void> authenticateUser(HttpServletResponse response){
        Cookie cookie = new Cookie("access_token",jwt_token);

        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60*2); // unit type is seconds

        response.addCookie(cookie);
=======

    @PostMapping("sign-in")
    public ResponseEntity<Void> authenticateUser(HttpServletResponse response){

        response.addCookie(CookieUtil.createCookie(jwt_token));
>>>>>>> ccac54b (new project)
        return ResponseEntity.ok().build();
    }
}
