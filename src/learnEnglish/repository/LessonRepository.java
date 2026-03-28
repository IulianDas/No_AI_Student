package learnEnglish.repository;

import learnEnglish.entity.Lesson;

import java.util.List;

public interface LessonRepository {

    List<Lesson> getLessons();
    void setLesson();
    List<Lesson> getLessonsByCourseId(int courseId);
}
