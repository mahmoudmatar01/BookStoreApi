package com.api.BooksApiWithMySql.factories;


import com.api.BooksApiWithMySql.responses.Response;

public abstract class BaseFactory<T> {

    abstract public Response<T> createResponse();
}
