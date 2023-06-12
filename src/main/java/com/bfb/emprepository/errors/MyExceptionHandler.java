package com.bfb.emprepository.errors;

import com.bfb.emprepository.exceptions.DatabaseEmptyException;
import com.bfb.emprepository.exceptions.InputFieldsEmptyException;
import com.bfb.emprepository.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Error> nullPointerExceptionHandler(HttpServletRequest req, HttpServletResponse res, Exception ex) {
        return new ResponseEntity<>(new Error(req.getRequestURI(),"This is message"), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(InputFieldsEmptyException.class)
    public ResponseEntity<Error> InputFieldsEmptyExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<>(new Error(req.getRequestURI(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> ResourceNotFoundExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<>(new Error(req.getRequestURI(),ex.getMessage()),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DatabaseEmptyException.class)
    public ResponseEntity<Error> DatabaseEmptyExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<>(new Error(req.getRequestURI(),ex.getMessage()),HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>("Please change your method",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> globalExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<Error>(new Error(req.getRequestURI(),ex.getMessage()),HttpStatus.BAD_REQUEST);
    }


}
