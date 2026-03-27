package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

public class QuizRepositoryImpl implements QuizRepository {

    private Question question;
    private static List<Quiz> quizRepository = new ArrayList<>();

    @Override
    public Quiz getQuiz() {
        return null;
    }

    @Override
    public void setQuiz() {

    }

    @Override
    public List<Quiz> getAllQuiz() {
        return List.of();
    }
}
