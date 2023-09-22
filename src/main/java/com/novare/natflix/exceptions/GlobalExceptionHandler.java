package com.novare.natflix.exceptions;

import com.novare.natflix.models.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String CONSTRAINT_VIOLATION = "Constraint violation: ";

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        String errorMessage = CONSTRAINT_VIOLATION + ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("400", errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(ConstraintViolationException ex) {

        String errorMessage = CONSTRAINT_VIOLATION + ex.getMessage();
        if(errorMessage.contains("Password must be minimum 8 characters long")) errorMessage="Password must be minimum 8 characters long";
        if(errorMessage.contains("item name should not be ")) errorMessage="item name should not be blank";
        if(errorMessage.contains("email id not valid")) errorMessage="Email id not valid";

        ErrorResponse errorResponse = new ErrorResponse("400", errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.toString());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {

        String errorMessage = "Authentication failed: " + ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("401", errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.toString());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsExceptionException(BadCredentialsException ex) {

        String errorMessage = "BadCredentialsException : " + ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("401", errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.toString());
    }


    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserAlreadyExistException(UserAlreadyExistException ex) {

        String errorMessage = "Registration failed: " + ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("400", errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.toString());
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {

        String errorMessage = "failed: " + ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("404", errorMessage);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse.toString());
    }


    private ResponseEntity<String> formatResponse(Exception ex){
        String errorMessage = CONSTRAINT_VIOLATION + ex.getMessage();

        ErrorResponse errorResponse = new ErrorResponse("400", errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse.toString());
    }

}
