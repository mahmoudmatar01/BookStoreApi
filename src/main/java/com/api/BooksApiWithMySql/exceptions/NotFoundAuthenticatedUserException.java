package com.api.BooksApiWithMySql.exceptions;

import org.springframework.security.core.AuthenticationException;

public class NotFoundAuthenticatedUserException extends AuthenticationException {
    public NotFoundAuthenticatedUserException(String s) {
        super(s);
    }
}
