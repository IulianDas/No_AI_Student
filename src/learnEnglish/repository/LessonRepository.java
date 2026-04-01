package learnEnglish.repository;

import learnEnglish.entity.Lesson;

import java.util.List;

public interface LessonRepository {

    List<Lesson> getLessons();
    int createLesson(int courseId);
    List<Lesson> getLessonsByCourseId(int courseId);

    void updateLesson(int courseId, int lessonId);

    void removeLessonById(int courseId);

    public int addLesson(int courseId);
}
