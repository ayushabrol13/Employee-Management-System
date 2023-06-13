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
        return new ResponseEntity<>(new Error(req.getRequestURI(),"Some null Pointer exception has occured","400","Some null pointer exception has occured."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InputFieldsEmptyException.class)
    public ResponseEntity<Error> InputFieldsEmptyExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<>(new Error(req.getRequestURI(), ex.getMessage(),"400","Some important field values missing.You must provide the field values for all required data."), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> ResourceNotFoundExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<>(new Error(req.getRequestURI(),ex.getMessage(),"404","The particular employee id provided is not found in the database. Please contact admin for further details"),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DatabaseEmptyException.class)
    public ResponseEntity<Error> DatabaseEmptyExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<>(new Error(req.getRequestURI(),ex.getMessage(),"404","The database does not contain any employee data. It is empty. Please contact admin."),HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>("Bad Request. The request method and the url are not compatible. Please check the method",HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> globalExceptionHandler(HttpServletRequest req, Exception ex){
        return new ResponseEntity<Error>(new Error(req.getRequestURI(),ex.getMessage(),"400","Some error has occured. Please contact admin for further details"),HttpStatus.BAD_REQUEST);
    }


}
