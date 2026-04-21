package org.example.repository;

import org.example.entity.Lesson;

import java.sql.SQLException;
import java.util.List;

public interface LessonRepository {

    List<Lesson> getLessons() throws SQLException;
    int createLesson(int courseId, Lesson newLesson) throws SQLException;
    List<Lesson> getLessonsByCourseId(int courseId) throws SQLException;
    void updateLesson(int indexPosition, Lesson updatedLesson) throws SQLException;
    void removeLessonById(int courseId, int lessonId) throws SQLException;

}
