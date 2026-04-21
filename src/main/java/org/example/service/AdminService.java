package org.example.service;

import java.sql.SQLException;

public interface AdminService {
    void updateSelectedCourse() throws SQLException;

    void createCourse() throws SQLException;

    void deleteCourseById(int courseId) throws SQLException;

    void getAllCourses() throws SQLException;

}
