package com.api.pal_points.Controllers;

import com.api.pal_points.Domain.User;
import com.api.pal_points.Dto.AuthResponse;
import com.api.pal_points.Dto.LoginRequest;
import com.api.pal_points.Service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = authService.login(request.getEmail(), request.getPassword());

        AuthResponse response = new AuthResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }







}