package com.api.BooksApiWithMySql.DTOs.auth.register;

import com.api.BooksApiWithMySql.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    private String userNameOrEmail;
    private String password;
}
