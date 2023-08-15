package com.api.BooksApiWithMySql.interfaces;

import com.api.BooksApiWithMySql.DTOs.auth.login.LoginRequestDto;
import com.api.BooksApiWithMySql.DTOs.auth.login.LoginResponseDto;
import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterRequestDto;
import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterResponseDto;
import com.api.BooksApiWithMySql.exceptions.NotFoundUserException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public interface BaseAuthenticationService {
    public RegisterResponseDto register(RegisterRequestDto dto) throws SQLIntegrityConstraintViolationException;
    public LoginResponseDto login(LoginRequestDto dto) throws NotFoundUserException;
}
