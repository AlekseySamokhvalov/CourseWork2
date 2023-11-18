package com.example.CourseWork2.service;

import com.example.CourseWork2.model.Question;
import com.example.CourseWork2.repository.JavaQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;
    @Test
    void testAdd() {
        //Подготовка входных данных
        String answer = "answer";
        String question = "question";

        //Подготовка ожидаемого результат
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);

        //Начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        assertEquals(expectedQuestion, actualQuestion);
        verify(javaQuestionRepository).add(expectedQuestion);
    }


    @Test
    void testAddTwoParam() {
        ////подготовка входных данных
        String question = "тест";
        String answer = "тест1";
        //подготовка ожидаемого результата
        Question expected = new Question(question, answer);
        //начало теста
        Question actual = javaQuestionService.add(question, answer);
        assertEquals(expected,actual);
    }

    @Test
    void testRemove() {
        //подготовка входных данных
        String question = "тест";
        String answer = "тест1";
        //подготовка ожидаемого результата
        Question expectedQuestion = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expectedQuestion))).thenReturn(expectedQuestion);
        //начало теста
        Question actualQuestion = javaQuestionService.add(question, answer);
        actualQuestion = javaQuestionService.remove(question, answer);
        assertEquals(expectedQuestion,actualQuestion);
    }

    @Test
    void testGetAll() {
        String question = "вопрос1";
        String answer = "тест11";
        String question1 = "вопрос2";
        String answer1 = "тест22";
        String question2 = "вопрос3";
        String answer2 = "тест33";
        Collection<Question> expected = new HashSet<>();
        expected.add(new Question(question, answer));
        expected.add(new Question(question1, answer1));
        expected.add(new Question(question2, answer2));
        //Начало теста
        when(javaQuestionService.getAll()).thenReturn(expected);
        Collection<Question> actual = javaQuestionService.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion() {

    }
}