package org.example.repository;

import org.example.entity.Answer;

import java.sql.SQLException;
import java.util.List;

public interface AnswerRepository {

    List<Answer> getAnswersByQuestionId(int questionId) throws SQLException;
    void updateAnswersByQuestionId(int questionId, List<Answer> answers) throws SQLException;
    int createAnswer(int questionId, Answer answers) throws SQLException;
    void deleteAnswer(int questionId, int answerId) throws SQLException;
}
