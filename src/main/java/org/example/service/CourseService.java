package org.example.service;

import org.example.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseService {
    void startLesson(int userId) throws SQLException;
    void getAllCourses() throws SQLException;
    void getUserProgress(int userId) throws SQLException;
    List<Integer> getCourseListByUsersId(int userId) throws SQLException;

    Course getCourseById(int courseId) throws SQLException;

    void getStartedCourses(List<Course> courses);
}
