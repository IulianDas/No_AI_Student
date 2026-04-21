package org.example.repository;

import org.example.entity.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuestionRepository {

    int  createQuestion(int lessonId, Question newQuestion) throws SQLException;
    List<Question> getAllQuestionByLessonId(int lessonId) throws SQLException;
    void removeQuestion(int lessonId, int questionId) throws SQLException;
    void updateQuestion(int id, Question updatedQusetion) throws SQLException;
}
