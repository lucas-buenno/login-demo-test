package com.example.login_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class LoginException extends DemoException {

    public LoginException() {
    }

    @Override
    public ProblemDetail toProblemDetail() {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        problemDetail.setTitle("Não foi possível realizar o login");
        problemDetail.setDetail("Senha e/ou e-mail incorretos");
        return problemDetail;
    }
}
