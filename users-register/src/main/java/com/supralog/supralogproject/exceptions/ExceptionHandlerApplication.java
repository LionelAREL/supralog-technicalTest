package com.supralog.supralogproject.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerApplication {
    
    
    /** 
     * @param ex
     * @return Map<String, String> error when MethodArgumentNotValidException is throw
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    
    /** 
     * @param ex
     * @return Map<String, String> error when HttpMessageNotReadableException is throw
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleNotReadable(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message",ex.getMessage());
        return errorMap;
    }

    
    /** 
     * @param ex
     * @return Map<String, String> error when DuplicateKeyException is throw
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DuplicateKeyException.class)
    public Map<String, String> handleDuplicateKey(DuplicateKeyException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message","user with this mail already exist");
        return errorMap;
    }
    
}
