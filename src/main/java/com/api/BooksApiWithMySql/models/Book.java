package com.api.BooksApiWithMySql.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books_jpa") // when using JPA
//@Table(name = "books") // when using JDBC
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String description;
    private double price;
    private int quantity;

    public Book(String title, String author, String description, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


    public Book(Long id, String title, String author, String description, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Book() {
    }
}
