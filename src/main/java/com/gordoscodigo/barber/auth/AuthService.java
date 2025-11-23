package com.gordoscodigo.barber.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gordoscodigo.barber.Jwt.JwtService;
import com.gordoscodigo.barber.User.Role;
import com.gordoscodigo.barber.User.User;
import com.gordoscodigo.barber.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request) {
       
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public AuthResponse register(RegisterRequest request) {
       User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstname(request.getFirstname())
            .lastname(request.lastname)
            .role(Role.USER)
            .build();

            userRepository.save(user);

            return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();

        
       
    }

}
