package com.example.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAmountException  extends RuntimeException {
    public QuestionAmountException(String message) {
        super(message);
    }
}
