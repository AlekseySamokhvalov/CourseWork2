package com.example.CourseWork2.controller;

import com.example.CourseWork2.exception.QuestionAmountException;
import com.example.CourseWork2.model.Question;
import com.example.CourseWork2.service.ExaminerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
public class ExamController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({QuestionAmountException.class})
    public String handleException(RuntimeException e){
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
