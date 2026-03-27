package learnEnglish.repository;

import learnEnglish.entity.Quiz;

import java.util.List;

public interface QuizRepository {
    Quiz getQuiz();
    void setQuiz();
    List<Quiz> getAllQuiz();
}
