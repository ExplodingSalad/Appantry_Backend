package com.example.appantry_backend.APIs.ProductAPI.ProductController;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/** This class handles exceptions to the expected JSON Response Body. E.g., if key names are mismatching, missing
 * or unrecognized keys are present in the JSON body*/

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(value = {UnrecognizedPropertyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex) {

        final String error = "JSON parse error: Unrecognized field " + "[ " + ex.getPropertyName() + " ]";

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}