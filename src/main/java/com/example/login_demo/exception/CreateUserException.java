package com.example.login_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CreateUserException extends DemoException {

    private String detail;

    public CreateUserException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Create User Exception");
        problemDetail.setDetail(detail);
        return problemDetail;
    }
}
