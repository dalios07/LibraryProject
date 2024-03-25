package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);}
    @ExceptionHandler( UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException( UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);}
    @ExceptionHandler(BookNotAvailbaleException.class)
    public ResponseEntity<?> handleBookNotAvailbaleException(BookNotAvailbaleException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);}
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException ex) {

        return new ResponseEntity<>("Identifiants incorrects.", HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler( DisabledException.class)
    public ResponseEntity<?> handleDisabledException( DisabledException ex) {

        return new ResponseEntity<>("utilisateur inactive.", HttpStatus.UNAUTHORIZED);
    }

}
