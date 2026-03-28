package learnEnglish.repository.impl;

import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuizRepository;

import java.util.List;

public class QuizRepositoryImpl implements QuizRepository {

    private static final Quiz quizA1Lesson1 = new Quiz(1, 1);
    private static final List<Quiz> quizzes = List.of(quizA1Lesson1);


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

    @Override
    public Quiz getQuizByLessonId(int lessonId) {
        return quizzes.stream().findFirst().filter(quiz -> quiz.getLessonId() == lessonId).orElseGet(Quiz::new);
    }
}
