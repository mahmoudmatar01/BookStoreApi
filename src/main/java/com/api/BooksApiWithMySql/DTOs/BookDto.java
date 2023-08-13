package com.api.BooksApiWithMySql.DTOs;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class BookDto {
    @NotBlank(message = "The title is required")
    @Size(min = 3, max =15 , message = "The title must be from 3 to 15 characters.")
    private String title;

    @NotBlank(message = "The Author is required")
    @NotNull(message = "The Author is required")
    private String author;

    @NotBlank(message = "The description is required")
    @NotNull(message = "The description is required")
    @Size(min = 5 ,max = 50 ,message = "The Description must be from 5 to 50 characters.")
    private String description;

    @NotNull(message = "The price is required.")
    @Min(value = 1 ,message = "The price must be greater than or equal to 1$.")
    private double price;

    @NotNull(message = "The quantity is required.")
    @Min(value = 0 ,message = "The quantity must be positive number.")
    private int quantity;
}
