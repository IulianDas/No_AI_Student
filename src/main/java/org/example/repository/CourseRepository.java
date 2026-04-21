package org.example.repository;

import org.example.entity.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseRepository {
    Course getCourse(int courseId) throws SQLException;
    List<Course> getAllCourses() throws SQLException;
    int createNewCourse(String name) throws SQLException;
    void removeCourse(int courseId) throws SQLException;
    void updateCourseName(int indexPosition, Course updatedCourseName) throws SQLException;

}
