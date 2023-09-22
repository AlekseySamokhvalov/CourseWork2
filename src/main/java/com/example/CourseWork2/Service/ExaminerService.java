package com.example.CourseWork2.Service;

import com.example.CourseWork2.Model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}