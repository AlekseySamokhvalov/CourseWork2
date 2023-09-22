package com.example.CourseWork2.Service;

import com.example.CourseWork2.Model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    default Question getRandomQuestion() {
        return null;
    }
}