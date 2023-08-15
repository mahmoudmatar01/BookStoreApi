package com.api.BooksApiWithMySql.DTOs.auth.register;

import com.api.BooksApiWithMySql.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponseDto {
    private String userName;
    private String email;
    private Role role;
}
