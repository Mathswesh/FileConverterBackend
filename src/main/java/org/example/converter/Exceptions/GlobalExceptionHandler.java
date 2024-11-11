package org.example.converter.Exceptions;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String,String> map = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String FieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            map.put(FieldName, errorMessage);
        });

        return new ResponseEntity<Map<String,String>>(map , HttpStatus.OK);
    }
}
