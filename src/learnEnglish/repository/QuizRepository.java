package learnEnglish.repository;

import learnEnglish.entity.Quiz;

import java.util.List;

public interface QuizRepository {

    void createQuiz(Quiz newQuiz);
    List<Quiz> getAllQuiz();
    void removeQuiz(int lessonId);
    Quiz getQuizByLessonId(int lessonId);
}
