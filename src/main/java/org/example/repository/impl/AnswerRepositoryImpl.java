package org.example.repository.impl;

import org.example.DB.DBConfig;
import org.example.entity.Answer;
import org.example.repository.AnswerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerRepositoryImpl extends DBConfig implements AnswerRepository {

    private static Connection connection;

    public AnswerRepositoryImpl() throws SQLException {
        connection = super.getConnection();
    }
@Override
public List<Answer> getAnswersByQuestionId(int questionId) throws SQLException {

        String query = "SELECT * FROM answers " +
                "INNER JOIN questions_to_answers ON answers.answer_id = questions_to_answers.answer_id " +
                "INNER JOIN questions ON questions.question_id = questions_to_answers.question_id " +
                "WHERE questions.question_id = ? " +
                "ORDER BY answers.answer_id ASC;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, questionId);
        ResultSet rs = stmt.executeQuery();
        List<Answer> answers = new ArrayList<>();
        Answer answer = null;

        while (rs.next()){
            answer = new Answer();
            answer.setId((int) rs.getLong("answer_id"));
            answer.setVariant(rs.getString("variant"));
            answer.setQuestionId((int) rs.getLong("question_id"));
            answers.add(answer);
        }
        rs.close();
        stmt.close();
        return answers;
    }

    @Override
    public void updateAnswersByQuestionId(int questionId, List<Answer> answers) throws SQLException {

        String query = "WITH target_answers AS ( " +
                "    SELECT answer_id, " +
                "           row_number() OVER (ORDER BY answer_id) as pos " +
                "    FROM questions_to_answers " +
                "    WHERE question_id = ? " +
                ") " +
                "UPDATE answers " +
                "SET content = CASE " +
                "    WHEN pos = 1 THEN ? " +
                "    WHEN pos = 2 THEN ? " +
                "    WHEN pos = 3 THEN ? " +
                "    WHEN pos = 4 THEN ? " +
                "END " +
                "FROM target_answers " +
                "WHERE answers.id = target_answers.answer_id;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, questionId);
        stmt.setString(2, String.valueOf(answers.get(0)));
        stmt.setString(3, String.valueOf(answers.get(1)));
        stmt.setString(4, String.valueOf(answers.get(2)));
        stmt.setString(5, String.valueOf(answers.get(3)));
        stmt.executeUpdate();
        stmt.close();
    }
    @Override
    public int createAnswer(int questionId, Answer answer) throws SQLException {
        String query = "INSERT INTO answers (variant) VALUES (?);";
        PreparedStatement stmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, answer.getVariant());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        int answerId = 0;
        while (rs.next()){
            answerId = (int) rs.getLong(1);
        }
        rs.close();
        stmt.close();
        createAnswersToQuestion(questionId, answerId);
        return answerId;
    }
    @Override
    public void deleteAnswer(int questionId, int answerId) throws SQLException {
        String query = "DELETE FROM questions_to_answers " +
                "    WHERE question_id = ? AND answer_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, questionId);
        stmt.setInt(2, answerId);
        stmt.executeUpdate();
        query = "DELETE FROM answers " +
                "WHERE answer_id = ? ;";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, answerId);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("\n Answer is deleted!");

    }

    private void createAnswersToQuestion(int questionId, int answerId) throws SQLException {
        String query = "INSERT INTO questions_to_answers (question_id, answer_id) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, questionId);
        stmt.setInt(2, answerId);
        stmt.executeUpdate();
        stmt.close();

    }

}
