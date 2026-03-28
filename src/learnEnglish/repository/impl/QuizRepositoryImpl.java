package learnEnglish.repository.impl;

import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

public class QuizRepositoryImpl implements QuizRepository {

    private static final List<Quiz> quizzes = new ArrayList<>();

    public QuizRepositoryImpl() {
        quizzes.add(new Quiz(1,1));
        quizzes.add(new Quiz(2,2));
        quizzes.add(new Quiz(3,3));
    }

    @Override
    public Quiz getQuiz() {
        return new Quiz();
    }

    @Override
    public void setQuiz() {

    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizzes;
    }

    @Override
    public Quiz getQuizByLessonId(int lessonId) {
        return quizzes.stream().filter(quiz -> quiz.getLessonId() == lessonId).findAny().orElseGet(Quiz::new);
    }
}
