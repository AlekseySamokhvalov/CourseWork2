package com.example.CourseWork2.service;

import com.example.CourseWork2.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {
    @Autowired
    private ExaminerService examinerService;

    @MockBean
    private QuestionService questionService;

    @Test
    void getQuestions_success() {
        //входные данные
        int amount = 1;
        Question q1 = new Question("1", "11");
        Question q2 = new Question("2", "22");

        Collection<Question> questions = Set.of(q1, q2);

        //ожидаемый результат
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(q1);
        Collection<Question> expectedQuestions = Set.of(q1);

        //начало теста
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        assertEquals(expectedQuestions, actualQuestions);
        verify(questionService).getAll();
        verify(questionService).getRandomQuestion();
        assertEquals(amount, actualQuestions.size());
    }
}