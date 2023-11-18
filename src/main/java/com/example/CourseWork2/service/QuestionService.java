package com.example.CourseWork2.service;

import com.example.CourseWork2.model.Question;

import java.util.Collection;
import java.util.Random;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
    Random getRandom1();

}