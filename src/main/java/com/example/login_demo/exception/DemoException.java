package com.example.login_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DemoException extends RuntimeException {

    public DemoException() {
    }

    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Ocorreu um erro");
        problemDetail.setDetail("Não foi possível realizar a ação.");
        return problemDetail;
    }
}
