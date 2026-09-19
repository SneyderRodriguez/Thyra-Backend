package com.planificadortareas.thyra.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthTestController {
    public Map<String, Object> testAuthentication(@AuthenticationPrincipal Jwt jwt) {
        return Map.of("authenticated", true, "userId", jwt.getSubject(), "email", jwt.getClaimAsString("email"));
    }
}
