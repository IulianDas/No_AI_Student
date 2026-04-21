package org.example.repository.impl;

import org.example.DB.DBConfig;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.repository.CourseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl extends DBConfig implements CourseRepository {

    private static Connection connection;

    public CourseRepositoryImpl() throws SQLException {
        connection = super.getConnection();
    }

    @Override
    public Course getCourse(int courseId) throws SQLException {
        String query = "SELECT * FROM courses " +
                       "INNER JOIN courses_to_lessons ON courses.course_id = courses_to_lessons.course_id " +
                       "INNER JOIN lessons ON lessons.lesson_id = courses_to_lessons.lesson_id " +
                       "WHERE courses.course_id = ? " +
                       "ORDER BY lessons.lesson_id ASC ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, courseId);
        ResultSet rs = stmt.executeQuery();
        List<Lesson> lessons = new ArrayList<>();
        Course course = null;
        while (rs.next()){
            course = new Course();
            course.setId((int) rs.getLong("course_id"));
            course.setName(rs.getString("course_name"));
            lessons.add(new Lesson((int) rs.getLong("lesson_id"), rs.getInt("lesson_order"), rs.getString("topic"), (int) rs.getLong("course_id")));
            while (rs.next()){
                lessons.add(new Lesson((int) rs.getLong("lesson_id"), rs.getInt("lesson_order"), rs.getString("topic"), (int) rs.getLong("course_id")));
            }
            course.setLessons(lessons);
        }
        rs.close();
        stmt.close();
        return course;
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        String query = "SELECT * FROM courses;";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Course> courses = new ArrayList<>();
        while (rs.next()){
            Course course = new Course();
            course.setId((int) rs.getLong("course_id"));
            course.setName(rs.getString("course_name"));
            courses.add(course);
        }
        rs.close();
        stmt.close();
        return courses;
    }

    @Override
    public int createNewCourse(String newCourse) throws SQLException {
        String query = "INSERT INTO courses (course_name) VALUES (?);";
        PreparedStatement stmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, newCourse);
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            return (int) rs.getLong(1);
        }
        return -1;
    }

    @Override
    public void updateCourseName(int courseId, Course updatedCourse) throws SQLException {
        String query = "UPDATE course SET course_name = ? WHERE course_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, updatedCourse.getName());
        stmt.setInt(2, courseId);
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void removeCourse(int courseId) throws SQLException {
        String query = "DELETE FROM courses WHERE course_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, courseId);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("\n Course is deleted!");
    }
}
