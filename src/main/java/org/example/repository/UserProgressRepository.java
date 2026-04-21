package org.example.repository;

import org.example.entity.UserProgress;

import java.sql.SQLException;
import java.util.List;

public interface UserProgressRepository {

    List<UserProgress> getCourseProgressByUserId(int userId) throws SQLException;
    void saveUserProgress(UserProgress userProgress) throws SQLException;
    void updateUserProgress(UserProgress userProgress) throws SQLException;
    UserProgress getCourseProgressByUserIdAndCourseId(int id, int courseId) throws SQLException;
    void deleteCourseProgress(int courseId) throws SQLException;
}
