package com.example.CourseWork2.service;

import com.example.CourseWork2.model.Question;
import com.example.CourseWork2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private Random random = null;
    private final QuestionRepository questionRepository;  //Collection<Question> questions = new HashSet<>();

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question,answer);
        questionRepository.remove(question1);
        return question1;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = questionRepository.getAll();
        Random random = new Random();
        int randomIdx = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(randomIdx);
    }
    @Override
    public Random getRandom1() {
        if (random == null) {
            random = new Random(20231106);
        }

        return random;
    }
}
