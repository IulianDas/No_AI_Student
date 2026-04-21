package org.example.service;

import org.example.entity.Lesson;

import java.sql.SQLException;

public interface QuestionService {

    void startQuiz(Lesson lessonQuiz, int userId) throws SQLException;
}
