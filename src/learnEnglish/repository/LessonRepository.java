package learnEnglish.repository;

import learnEnglish.entity.Lesson;

import java.util.List;

public interface LessonRepository {

    List<Lesson> getLessons();
    void setLesson();
    Lesson getLesson();
    List<Lesson> getLessonsByCourseId(int courseId);
}
