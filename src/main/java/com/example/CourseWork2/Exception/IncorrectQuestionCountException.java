package com.example.CourseWork2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectQuestionCountException extends RuntimeException{

    public IncorrectQuestionCountException(String message) {
        super(message);
    }
}
