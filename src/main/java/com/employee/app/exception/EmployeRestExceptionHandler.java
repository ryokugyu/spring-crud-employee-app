package com.employee.app.exception;


import com.employee.app.errorResponse.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
        EmployeeErrorResponse err = new EmployeeErrorResponse();

        err.setMessage(exc.getMessage());
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

    }
}

