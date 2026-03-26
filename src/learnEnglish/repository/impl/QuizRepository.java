package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizRepository implements learnEnglish.repository.QuizRepository {

    private Question question;
    private static List<Quiz> quizRepository = new ArrayList<>();

    @Override
    public Quiz getQuiz() {
        return null;
    }

    @Override
    public void setQuiz() {

    }
}
