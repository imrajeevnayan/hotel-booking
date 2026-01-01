package com.hotelbooking.controller;

import com.hotelbooking.dto.AuthResponse;
import com.hotelbooking.dto.LoginRequest;
import com.hotelbooking.dto.SignupRequest;
import com.hotelbooking.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<AuthResponse> getCurrentUser(
            org.springframework.security.core.Authentication authentication) {
        // We can get the user details from the Authentication object
        // Depending on how your UserDetails is implemented (CustomUserDetails or just
        // User)
        // Let's assume AuthService can handle this or retrieve it directly here.
        // Actually, let's keep it simple and use AuthService if possible, or just build
        // response here.
        // But we need the User entity.
        return ResponseEntity.ok(authService.getCurrentUser(authentication.getName()));
    }
}
