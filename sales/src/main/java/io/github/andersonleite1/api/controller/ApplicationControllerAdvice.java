package io.github.andersonleite1.api.controller;

import io.github.andersonleite1.api.ApiErrors;
import io.github.andersonleite1.exception.BusinessRuleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBusinessRuleException(BusinessRuleException ex){
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }
}
