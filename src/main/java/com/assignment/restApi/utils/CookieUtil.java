package com.assignment.restApi.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieUtil {
    public static String JWT_COOKIE_NAME = "access_token";

    public static Cookie createCookie(String token) {
        Cookie cookie = new Cookie("access_token", token);

        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 2); // unit type is seconds
        return cookie;
    }

    public static String extractToken(HttpServletRequest request) {
        if (request.getCookies() == null) return null;

        for (Cookie cookie : request.getCookies()) {
            if (JWT_COOKIE_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
