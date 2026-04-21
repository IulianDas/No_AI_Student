package org.example.repository.impl;

import org.example.DB.DBConfig;
import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.repository.LessonRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl extends DBConfig implements LessonRepository {

    private static Connection connection;

    public LessonRepositoryImpl() throws SQLException {
        connection = super.getConnection();
    }

    @Override
    public List<Lesson> getLessons() throws SQLException {
        String query =  "SELECT * FROM courses " +
                        "INNER JOIN courses_to_lessons ON courses.course_id = courses_to_lessons.course_id " +
                        "INNER JOIN lessons ON lessons.lesson_id = courses_to_lessons.lesson_id;";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        List<Lesson> lessons = new ArrayList<>();
        while (rs.next()){
            Lesson lesson = new Lesson();
            lesson.setId((int) rs.getLong("lesson_id"));
            lesson.setLessonOrder(rs.getInt("lesson_order"));
            lesson.setTopic(rs.getString("topic"));
            lesson.setDescription(rs.getString("description"));
            lesson.setParagraph(rs.getString("paragraph"));
            lesson.setCourseId((int) rs.getLong("course_id"));
            lessons.add(lesson);
        }
        rs.close();
        stmt.close();
        return lessons;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(int courseId) throws SQLException {
        String query =  "SELECT * FROM lessons " +
                "INNER JOIN courses_to_lessons ON lessons.lesson_id = courses_to_lessons.lesson_id " +
                "INNER JOIN courses ON courses.course_id = courses_to_lessons.course_id " +
                "WHERE courses_to_lessons.course_id = ? " +
                "ORDER BY lessons.lesson_id ASC;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, courseId);
        ResultSet rs = stmt.executeQuery();
        List<Lesson> lessons = new ArrayList<>();
        while (rs.next()){
            Lesson lesson = new Lesson();
            lesson.setId((int) rs.getLong("lesson_id"));
            lesson.setLessonOrder(rs.getInt("lesson_order"));
            lesson.setTopic(rs.getString("topic"));
            lesson.setDescription(rs.getString("description"));
            lesson.setParagraph(rs.getString("paragraph"));
            lesson.setCourseId((int) rs.getLong("course_id"));
            lessons.add(lesson);
        }
        rs.close();
        stmt.close();
        return lessons;
    }

    @Override
    public int createLesson(int courseId, Lesson newLesson) throws SQLException {
        String query = "INSERT INTO lessons (lesson_order, topic, description, paragraph)  VALUES (?,?,?,?);";
        PreparedStatement stmt = connection.prepareStatement(query,  Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, newLesson.getLessonOrder());
        stmt.setString(2, newLesson.getTopic());
        stmt.setString(3, newLesson.getDescription());
        stmt.setString(4, newLesson.getParagraph());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        int lessonId = 0;
        while (rs.next()){
            lessonId = (int) rs.getLong(1);
        }
        rs.close();
        stmt.close();
        createCourseToLesson(courseId, lessonId);
        return lessonId;

    }


    @Override
    public void updateLesson(int lessonId, Lesson updatedLesson) throws SQLException {
        String query = "UPDATE lessons SET lesson_order = ? " +
                                        ", topic = ? " +
                                        ", description = ? " +
                                        ", paragraph = ? " +
                                        " WHERE lesson_id = ?;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, updatedLesson.getLessonOrder());
        stmt.setString(2, updatedLesson.getTopic());
        stmt.setString(3, updatedLesson.getDescription());
        stmt.setString(4, updatedLesson.getParagraph());
        stmt.setInt(5, lessonId);
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void removeLessonById(int courseId, int lessonId) throws SQLException {
        String query = "DELETE FROM courses_to_lessons " +
                "    WHERE course_id = ? AND lessons_id = ? ;";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, courseId);
        stmt.setInt(2, lessonId);
        stmt.executeUpdate();
        query = "DELETE FROM lessons " +
                "WHERE lessons_id = ? ;";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, lessonId);
        stmt.executeUpdate();
        stmt.close();
        System.out.println("\n Lesson is deleted!");

    }


    private void createCourseToLesson (int courseId, int lessonId) throws SQLException {
        String query = "INSERT INTO courses_to_lessons (course_id, lesson_id) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, courseId);
        stmt.setInt(2, lessonId);
        stmt.executeUpdate();
        stmt.close();
    }
}
