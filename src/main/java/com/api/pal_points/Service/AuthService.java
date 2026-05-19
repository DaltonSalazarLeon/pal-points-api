package com.api.pal_points.Service;

import com.api.pal_points.Domain.AuthProvider;
import com.api.pal_points.Domain.User;
import com.api.pal_points.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {

        // verificar si ya existe
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        // 🔥 ENCRIPTAR PASSWORD
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // provider por defecto
        user.setProvider(AuthProvider.LOCAL);

        return userRepository.save(user);
    }
}