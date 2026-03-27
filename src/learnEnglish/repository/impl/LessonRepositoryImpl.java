package learnEnglish.repository.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

public class LessonRepositoryImpl implements learnEnglish.repository.LessonRepository {

 //   private Lesson lessonA1 = new Lesson(1,topic,description,paragraph,quiz);
    private static QuizRepository quiz = new QuizRepositoryA1Impl();
    private static Lesson courseA1Lesson1 = new Lesson(1,"Names","In english we have different names you, me, dog and cat.","You are 100% Human, no way to be someone else ", 1);
    private static List<Lesson> lessons = new ArrayList<>();

    @Override
    public List<Lesson> getLessons() {
        lessons.add(courseA1Lesson1);
        return lessons;
    }
    public Lesson getLesson() {
        return courseA1Lesson1;
    }

    @Override
    public void setLesson() {

    }
}
