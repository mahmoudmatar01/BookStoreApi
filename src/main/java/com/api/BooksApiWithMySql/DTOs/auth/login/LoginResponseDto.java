package com.api.BooksApiWithMySql.DTOs.auth.login;

import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterResponseDto;
import com.api.BooksApiWithMySql.models.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDto {
    private String userName;
    private String email;
    private Role role;
    private boolean isAuthenticated;
    private String token;
}
