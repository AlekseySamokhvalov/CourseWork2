package com.example.CourseWork2.Controller;

import com.example.CourseWork2.Exception.QuestionAmountException;
import com.example.CourseWork2.Model.Question;
import com.example.CourseWork2.Service.ExaminerService;
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
