package com.api.BooksApiWithMySql.DTOs.auth.login;

import com.api.BooksApiWithMySql.DTOs.auth.register.RegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto extends RegisterRequestDto {
    private String confirmPassword;
}
