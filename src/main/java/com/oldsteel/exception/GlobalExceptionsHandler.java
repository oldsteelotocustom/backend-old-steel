package com.oldsteel.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(errMessage(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> errMessage(List<String> errors){
        Map<String, List<String>> response = new HashMap<>();
        response.put("error", errors);
        return response;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> ProductNotFound(ProductNotFoundException ex){
        List<String> error = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(errMessage(error), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OurClientNotFountException.class)
    public ResponseEntity<Map<String, List<String>>> OurClientNotFound(OurClientNotFountException ex){
        List<String> error = Collections.singletonList(ex.getMessage());
        return new ResponseEntity<>(errMessage(error), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
