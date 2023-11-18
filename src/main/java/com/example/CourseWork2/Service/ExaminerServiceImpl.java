package com.example.CourseWork2.Service;

import com.example.CourseWork2.Exception.QuestionAmountException;
import com.example.CourseWork2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        int countQuestions = questionService.getAll().size();
        if (countQuestions < amount) {
            throw new QuestionAmountException(String.format("Запрошено %s, всего вопросов %s", amount, countQuestions));
        }

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) { questions.add(questionService.getRandomQuestion()); }

        return questions;
    }
}
