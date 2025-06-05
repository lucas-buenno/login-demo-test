package com.example.login_demo.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(DemoException.class)
    public ProblemDetail handlerDemoException(DemoException ex) {
        return ex.toProblemDetail();
    }
}
