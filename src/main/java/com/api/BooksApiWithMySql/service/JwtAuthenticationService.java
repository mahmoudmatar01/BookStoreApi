package com.api.BooksApiWithMySql.service;

import com.api.BooksApiWithMySql.DTOs.auth.login.LoginRequestDto;
import com.api.BooksApiWithMySql.DTOs.auth.login.LoginResponseDto;
import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterRequestDto;
import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterResponseDto;
import com.api.BooksApiWithMySql.config.JwtService;
import com.api.BooksApiWithMySql.exceptions.NotFoundAuthenticatedUserException;
import com.api.BooksApiWithMySql.exceptions.NotFoundUserException;
import com.api.BooksApiWithMySql.exceptions.UsedUserNameException;
import com.api.BooksApiWithMySql.interfaces.BaseAuthenticationService;
import com.api.BooksApiWithMySql.models.Role;
import com.api.BooksApiWithMySql.models.User;
import com.api.BooksApiWithMySql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationService implements BaseAuthenticationService {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponseDto register(RegisterRequestDto dto) throws UsedUserNameException {
        var user = User
                .builder()
                .userName(dto.getUserNameOrEmail())
                .email(dto.getUserNameOrEmail())
                .role(Role.ROLE_USER)
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        try {
            User savedUser = repository.save(user);
            return RegisterResponseDto
                    .builder()
                    .email(savedUser.getEmail())
                    .userName(savedUser.getUsername())
                    .role(savedUser.getRole())
                    .build();
        } catch (Exception e) {
            System.out.println("Caught Exception");
            throw new UsedUserNameException("There is already user with that user name");
        }
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) throws NotFoundUserException, NotFoundAuthenticatedUserException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getUserNameOrEmail(),
                            dto.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new NotFoundAuthenticatedUserException("There is no authenticated user with that credentials");
        }

        var user = repository.findUserByUserName(dto.getUserNameOrEmail())
                .orElseThrow(() -> new NotFoundUserException("There is no user with that email."));
        Map<String, Object> claims = Map.of("userId", user.getId(), "email", user.getEmail());
        var token = jwtService.generateToken(claims, user);
        return LoginResponseDto.builder()
                .isAuthenticated(true)
                .userName(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }
}
