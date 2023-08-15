package com.api.BooksApiWithMySql.controllers;

import com.api.BooksApiWithMySql.DTOs.auth.login.LoginRequestDto;
import com.api.BooksApiWithMySql.DTOs.auth.login.LoginResponseDto;
import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterRequestDto;
import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterResponseDto;
import com.api.BooksApiWithMySql.exceptions.NotFoundAuthenticatedUserException;
import com.api.BooksApiWithMySql.exceptions.NotFoundUserException;
import com.api.BooksApiWithMySql.service.JwtAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtAuthenticationService authService;

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto dto) throws NotFoundUserException, NotFoundAuthenticatedUserException {
        return ResponseEntity.ok(authService.login(dto));
    }
}
