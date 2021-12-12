package com.example.appantry_backend.APIs;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/** This class handles exceptions from the API calls */

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GenericExceptionHandler {

    // Handles Incorrect/Incomplete JSON Keys
    @ExceptionHandler(value = {UnrecognizedPropertyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex) {

        final String error = "JSON parse error: Unrecognized field " + "[ " + ex.getPropertyName() + " ]";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Handles incorrect Values for Enums
    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleGenericException(InvalidFormatException ex) {

        final String error = "JSON parse error: Unrecognized field " + "\"" + ex.getValue() + "\" ";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Handles general exceptions
    /*
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleGenericException(Exception ex) {
        System.out.println(ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
    } */
}