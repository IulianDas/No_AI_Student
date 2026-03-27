package learnEnglish.repository;

import learnEnglish.entity.Question;

import java.util.List;

public interface QuestionRepository {

    Question getQuestion();
    void  setQuestion();
    List<Question> getAllQuestion();

}
