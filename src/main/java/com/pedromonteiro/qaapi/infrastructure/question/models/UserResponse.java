package com.pedromonteiro.qaapi.infrastructure.question.models;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public record UserResponse(
    String id,
    String name,
    String email
) {
    public static UserResponse getCurrentUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var jwt = (Jwt) auth.getPrincipal();
        var userId = jwt.getSubject();
        var name = jwt.getClaim("preferred_username").toString();
        var email = jwt.getClaim("email").toString();

        return new UserResponse(userId, name, email);
    }
    
}
