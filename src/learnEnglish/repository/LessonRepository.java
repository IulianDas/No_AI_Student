package learnEnglish.repository;

import learnEnglish.entity.Lesson;

import java.util.List;

public interface LessonRepository {

    List<Lesson> getLessons();
    void createLesson(Lesson newLesson);
    List<Lesson> getLessonsByCourseId(int courseId);
    void updateLesson(int indexPosition, Lesson updatedLesson);
    void removeLessonById(int courseId);

}
