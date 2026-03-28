package learnEnglish.repository.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.repository.LessonRepository;

import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl implements LessonRepository {

    private static final Lesson courseA1Lesson1 = new Lesson(1, 1,"WhoAreYou","In english we have different names you, me, dog and cat.","You are 100% Human, no way to be someone else ", 1);
    private static final Lesson courseA1Lesson2 = new Lesson(2, 2,"WhoAreMe","In english we have different names you, me, dog and cat.","I am 100% Machine, no way to be someone else ", 1);

    private static final List<Lesson> lessons = new ArrayList<>();

    @Override
    public List<Lesson> getLessons() {
        lessons.add(courseA1Lesson1);
        lessons.add(courseA1Lesson2);
        return lessons;
    }
    public Lesson getLesson() {
        return courseA1Lesson1;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(int courseId) {
        return lessons.stream().filter(lesson -> lesson.getCourseId() == courseId).toList();
    }

    @Override
    public void setLesson() {

    }
}
