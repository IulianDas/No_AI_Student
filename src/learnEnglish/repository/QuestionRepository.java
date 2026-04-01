package learnEnglish.repository;

import learnEnglish.entity.Question;

import java.util.List;

public interface QuestionRepository {

    void  createQuestion(int quizId);
    List<Question> getAllQuestion();
    List<Question> getAllQuestionByQuizId(int id);
    void removeQuestion(int quizId);

    void updateQuestion(int id);
}
