package com.oldsteel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OurClientNotFountException extends RuntimeException{

    public OurClientNotFountException(String message){
        super(message);
    }

    public OurClientNotFountException(String message, Throwable cause) {
        super(message, cause);
    }
}
