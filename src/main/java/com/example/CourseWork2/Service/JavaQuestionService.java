package com.example.CourseWork2.Service;

import com.example.CourseWork2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.*;
//import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService {

    Collection<Question> questions = new HashSet<>();

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
    public Question remove(String question, String answer) {
        Question questionForRemove = new Question(question, answer);
        questions.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomIdx = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIdx);
    }
}