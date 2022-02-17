package com.example.appantry_backend.APIs;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.hibernate.TransientObjectException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/** This class handles exceptions from the API calls */

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GenericExceptionHandler {

    private String responseStatusLabel = "Response Status";
    private String errorMessageLabel = "Message";

    private String responseStatus;
    private String errorMessage;
    private Map<String, String> map;


    // Handles Incorrect/Incomplete JSON Keys
    @ExceptionHandler(value = {UnrecognizedPropertyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleUnrecognizedPropertyException(UnrecognizedPropertyException ex) {

        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "Invalid key " + "'" + ex.getPropertyName() + "'";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    // Handles incorrect Values for Product Category Enum
    @ExceptionHandler(value = {InvalidFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleInvalidCategoryException(InvalidFormatException ex) {

        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "Invalid value for key 'productCategory'";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    // Handles invalid PUT requests, where product may not exist
    @ExceptionHandler(value = {NoSuchElementException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {

        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "The item specified does not exist!";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    // Handles invalid DELETE requests, where product does not exist
    @ExceptionHandler(value = {EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleDeletionOfNonExistantValue(EmptyResultDataAccessException ex) {

        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "The item specified does not exist!";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleNullValueInItemName(MethodArgumentNotValidException ex) {

        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "Item name cannot be null. Please specify a name.";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    // handle invalid items in lists in POST requests
    @ExceptionHandler(value = {TransientObjectException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleInvalidListItems(TransientObjectException ex) {
        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "Item can't be added to list. Item does not exist! Please provide a valid item ID.";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    // handle non existant lists


    // handle invalid HTTP message format
    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleInvalidRequestFormat(HttpMessageNotReadableException ex) {
        map = new LinkedHashMap<>();
        responseStatus = HttpStatus.BAD_REQUEST.value() + " " + HttpStatus.BAD_REQUEST.getReasonPhrase();
        errorMessage = "Invalid request format.";

        map.put(responseStatusLabel, responseStatus);
        map.put(errorMessageLabel, errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
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