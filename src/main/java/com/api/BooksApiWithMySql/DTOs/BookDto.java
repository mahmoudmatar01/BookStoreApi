package com.api.BooksApiWithMySql.DTOs;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String author;
    private String description;
    private double price;
    private int quantity;
}
