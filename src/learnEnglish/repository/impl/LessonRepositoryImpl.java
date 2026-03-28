package learnEnglish.repository.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.repository.LessonRepository;

import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl implements LessonRepository {

    private static final List<Lesson> lessons = new ArrayList<>();

    public LessonRepositoryImpl() {
        lessons.add(new Lesson(1, 1,"WhoAreYou","In english we have different names you, me, dog and cat.","You are 100% Human, no way to be someone else ", 1));
        lessons.add(new Lesson(2, 2,"WhoAreMe","In english we have different names you, me, dog and cat.","I am 100% Machine, no way to be someone else ", 1));
        lessons.add(new Lesson(3, 1,"Present simple Time in English","In english we have different times. PrS mean that something is happening right now","Present Simple example: I run,eat,talk,etc", 2));
    }

    @Override
    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(int courseId) {
        return lessons.stream().filter(lesson -> lesson.getCourseId() == courseId).toList();
    }

    @Override
    public void setLesson() {

    }
}
