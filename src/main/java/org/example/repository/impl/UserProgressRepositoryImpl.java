package org.example.repository.impl;

import org.example.DB.DBConfig;
import org.example.entity.UserProgress;
import org.example.repository.UserProgressRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserProgressRepositoryImpl extends DBConfig implements UserProgressRepository {

    private static Connection connection;

    public UserProgressRepositoryImpl() throws SQLException {
        connection = super.getConnection();
    }

    @Override
    public List<UserProgress> getCourseProgressByUserId(int userId) throws SQLException {
        String query = "SELECT * FROM users_progress " +
                "WHERE user_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        List<UserProgress> userProgressList = new ArrayList<>();
        UserProgress userProgress = null;
        while (rs.next()){
            userProgress = new UserProgress();
            userProgress.setUser(rs.getInt("user_id"));
            userProgress.setCourseId(rs.getInt("course_id"));
            userProgress.setProgressLessonCounter(rs.getInt("progress_lesson_counter"));
            userProgressList.add(userProgress);
        }
        rs.close();
        stmt.close();
        return userProgressList;
    }

    @Override
    public void saveUserProgress(UserProgress userProgress) throws SQLException {
        String query = "INSERT INTO users_progress  (user_id, course_id, progress_lesson_counter) VALUES (?, ?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userProgress.getUserId());
        stmt.setInt(2, userProgress.getCourseId());
        stmt.setInt(3, userProgress.getProgressLessonCounter());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void updateUserProgress(UserProgress updateProgress) throws SQLException {
        String query = "UPDATE users_progress " +
                "SET progress_lesson_counter = ? " +
                "WHERE user_id = ? AND course_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, updateProgress.getProgressLessonCounter());
        stmt.setInt(2, updateProgress.getUserId());
        stmt.setInt(3, updateProgress.getCourseId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public UserProgress getCourseProgressByUserIdAndCourseId(int userId, int courseId) throws SQLException {
        String query = "SELECT * FROM users_progress " +
                "WHERE user_id = ? AND course_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, userId);
        stmt.setInt(2, courseId);
        ResultSet rs = stmt.executeQuery();
        UserProgress userProgress = null;
        while (rs.next()){
            userProgress = new UserProgress();
            userProgress.setUser(rs.getInt("user_id"));
            userProgress.setCourseId(rs.getInt("course_id"));
            userProgress.setProgressLessonCounter(rs.getInt("progress_lesson_counter"));
        }
        rs.close();
        stmt.close();
        return userProgress;
    }
    @Override
    public void deleteCourseProgress(int courseId) throws SQLException {
        String query = "DELETE FROM users_progress WHERE course_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, courseId);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("\n Progress is deleted!");

    }
}
