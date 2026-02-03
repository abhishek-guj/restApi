package com.assignment.restApi.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    @Value("${jwt_token}")
    String jwtToken;

    @Bean
<<<<<<< HEAD
    public String getToken(){
=======
    public String generateToken(){
>>>>>>> ccac54b (new project)
        return jwtToken;
    }

    @Bean
    public boolean verifyToken(String token){
        return jwtToken.equals(token);
    }
}
