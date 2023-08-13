package com.api.BooksApiWithMySql.exceptions;

import com.api.BooksApiWithMySql.factories.FailureFactory;
import com.api.BooksApiWithMySql.responses.FailureResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundResourceCustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public FailureResponse resourceNotFoundException(NotFoundResourceCustomException ex, WebRequest request) {
        FailureFactory factory = new FailureFactory(ex.getMessage(), 404);
        return (FailureResponse) factory.createResponse();
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FailureResponse globalException(Exception ex, WebRequest request) {
        FailureFactory factory = new FailureFactory(ex.getMessage(), 500);
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
