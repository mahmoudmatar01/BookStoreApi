package com.api.BooksApiWithMySql.exceptions;

import com.api.BooksApiWithMySql.factories.FailureFactory;
import com.api.BooksApiWithMySql.responses.FailureResponse;
import io.jsonwebtoken.MalformedJwtException;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {


    @ExceptionHandler(MalformedJwtException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FailureResponse jwtExceptionHandling(MalformedJwtException e, WebRequest request) {
        FailureFactory factory = new FailureFactory(e.getMessage(), 400);
        return (FailureResponse) factory.createResponse();
    }

    @ExceptionHandler({NotFoundResourceCustomException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public FailureResponse resourceNotFoundException(NotFoundResourceCustomException ex, WebRequest request) {
        FailureFactory factory = new FailureFactory(ex.getMessage(), 404);
        return (FailureResponse) factory.createResponse();
    }

    @ExceptionHandler(NotFoundAuthenticatedUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public FailureResponse notFoundAuthenticatedUserHandling(NotFoundAuthenticatedUserException e, WebRequest request) {
        FailureFactory factory = new FailureFactory(e.getMessage(), 404);
        return (FailureResponse) factory.createResponse();
    }


    @ExceptionHandler(UsedUserNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public FailureResponse usedUserNameExceptionHandling(UsedUserNameException e, WebRequest request) {
        FailureFactory factory = new FailureFactory(e.getMessage(), 400);
        return (FailureResponse) factory.createResponse();
    }

    @ExceptionHandler(NotFoundUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public FailureResponse notRegisteredUserAuthException(NotFoundUserException e, WebRequest request) {
        FailureFactory factory = new FailureFactory(e.getMessage(), 404);
        return (FailureResponse) factory.createResponse();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FailureResponse globalException(Exception ex, WebRequest request) {
        FailureFactory factory = new FailureFactory(ex.getMessage(), 500);
        System.out.println(ex.getMessage());
        System.out.println(Arrays.toString(ex.getStackTrace()));
        System.out.println(Arrays.toString(new Throwable[]{ex.getCause()}));

        return (FailureResponse) factory.createResponse();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValidRequestBody(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
