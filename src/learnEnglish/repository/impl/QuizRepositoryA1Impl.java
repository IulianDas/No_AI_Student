package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuizRepository;

import java.util.Arrays;
import java.util.List;

public class QuizRepositoryA1Impl implements QuizRepository {

    private Question question;

    private static Quiz quizA1Lesson1 = new Quiz(1, 1);
    private static List<Quiz> quizzes = Arrays.asList(quizA1Lesson1);


    @Override
    public Quiz getQuiz() {
        return quizA1Lesson1;
    }

    @Override
    public void setQuiz() {

    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizzes;
    }
}
