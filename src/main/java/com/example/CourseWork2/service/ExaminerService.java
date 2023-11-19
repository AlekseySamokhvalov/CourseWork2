package com.example.CourseWork2.service;

import com.example.CourseWork2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}