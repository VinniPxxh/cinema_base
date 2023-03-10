package com.kata.cinema.base.webapp.controllers;

import com.kata.cinema.base.exceptions.NotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalException(Exception exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundByIdException.class)
    public ResponseEntity<ErrorResponse> notFoundByIdException(NotFoundByIdException idException) {
        return new ResponseEntity<>(new ErrorResponse(idException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
