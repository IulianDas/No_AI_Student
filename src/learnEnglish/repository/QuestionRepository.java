package learnEnglish.repository;

import learnEnglish.entity.Question;

import java.util.List;

public interface QuestionRepository {

    void  setQuestion();
    List<Question> getAllQuestion();

    List<Question> getAllQuestionByQuizzId(int id);
}
