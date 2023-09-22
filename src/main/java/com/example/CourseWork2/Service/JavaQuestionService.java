package com.example.CourseWork2.Service;

import com.example.CourseWork2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIdx = random.nextInt(questions.size());
        return questions.stream()
                .collect()
                .get(randomIdx);
    }
}