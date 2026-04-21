package org.example.repository.impl;

import org.example.DB.DBConfig;
import org.example.entity.Question;
import org.example.repository.QuestionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl extends DBConfig implements QuestionRepository {

    private static Connection connection;

    public QuestionRepositoryImpl() throws SQLException {
        connection = super.getConnection();
    }

    @Override
    public int createQuestion(int lessonId, Question newQuestion) throws SQLException {
        String query = "INSERT INTO questions (question, right_answer) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, newQuestion.getQuestion());
        stmt.setInt(2, newQuestion.getRightAnswer());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        int questionId = 0;
        while (rs.next()){
            questionId = (int) rs.getLong(1);
        }
        rs.close();
        stmt.close();
        createQuestionToLesson(lessonId, questionId);
        return questionId;
    }

    @Override
    public List<Question> getAllQuestionByLessonId(int lessonId) throws SQLException {
        String query =  "SELECT * FROM questions " +
                "INNER JOIN lessons_to_questions ON questions.question_id = lessons_to_questions.question_id " +
                "INNER JOIN lessons ON lessons.lesson_id = lessons_to_questions.lesson_id " +
                "WHERE lessons.lesson_id = ? " +
                "ORDER BY questions.question_id ASC;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, lessonId);
        ResultSet rs = stmt.executeQuery();
        List<Question> questions = new ArrayList<>();
        Question question = null;
        while (rs.next()){
            question = new Question();
            question.setId((int) rs.getLong("question_id"));
            question.setQuestion(rs.getString("question"));
            question.setRightAnswer(rs.getInt("right_answer"));
            questions.add(question);
        }
        rs.close();
        stmt.close();
        return questions;
    }

    @Override
    public void removeQuestion(int lessonId, int questionId) throws SQLException {
        String query = "DELETE FROM lessons_to_questions " +
                "    WHERE lessons_id = ? AND question_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, lessonId);
        stmt.setInt(2, questionId);
        stmt.executeUpdate();
        query = "DELETE FROM questions " +
                "WHERE question_id = ? ;";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, questionId);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("\n Questions is deleted!");
    }

    @Override
    public void updateQuestion(int questionId, Question updatedQuestion) throws SQLException {

        String query = "UPDATE questions SET question = ? "  +
                                          ", right_answer = ? " +
                                          " WHERE question_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, updatedQuestion.getQuestion());
        stmt.setInt(2, updatedQuestion.getRightAnswer());
        stmt.setInt(3, questionId);
        stmt.executeUpdate();
        stmt.close();

    }

    private void createQuestionToLesson(int lessonId, int questionId) throws SQLException {
        String query = "INSERT INTO lessons_to_questions (lesson_id, question_id) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, lessonId);
        stmt.setInt(2, questionId);
        stmt.executeUpdate();
        stmt.close();
    }

}
