package com.api.BooksApiWithMySql.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response<T> {
    private final boolean status;
    private final String message;
    private final T data;
}
