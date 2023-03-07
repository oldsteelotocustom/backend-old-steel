package com.oldsteel.helper;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessages {

    public static List<String> throwError(Errors errors){
        List<String> message = new ArrayList<>();
        for(ObjectError objectError: errors.getAllErrors()){
            message.add(objectError.getDefaultMessage());
        }
        return message;
    }
}
