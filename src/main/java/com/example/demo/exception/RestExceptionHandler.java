package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler( {NotFoundException.class} )
    public ResponseEntity<String> handleResourceNotFound(Exception ex) {

        return new ResponseEntity<String>("Resource_NOT_FOUND", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequests(Exception ex) {

        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {

        return new ResponseEntity<String>("SERVICE_UNAVAILABLE", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
