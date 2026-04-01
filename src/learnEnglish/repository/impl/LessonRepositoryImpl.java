package learnEnglish.repository.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.repository.LessonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LessonRepositoryImpl implements LessonRepository {

    private static final List<Lesson> lessons = new ArrayList<>();

    public LessonRepositoryImpl() {
        lessons.add(new Lesson(1, 1,"WhoAreYou","In english we have different names you, me, dog and cat.","You are 100% Human, no way to be someone else ", 1));
        lessons.add(new Lesson(2, 2,"WhoAreMe","In english we have different names you, me, dog and cat.","I am 100% Machine, no way to be someone else ", 1));
        lessons.add(new Lesson(3, 1,"Present simple Time in English","In english we have different times. PrS mean that something is happening right now","Present Simple example: I run,eat,talk,etc", 2));
        lessons.add(new Lesson(4, 2,"Past simple Time in English","In english we have different times. PstS mean that something is happened and finish","Present Simple example: I ran, I bought, etc", 2));
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
    public int createLesson(int courseId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce Name of the lesson: \n");
        String topic = scanner.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        String description = scanner.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        String paragraph = scanner.nextLine();
        int lessonNewId = lessons.getLast().getId()+1;
        lessons.add( new Lesson(lessonNewId, 1, topic, description, paragraph, courseId));
        return lessonNewId;
    }
    @Override
    public int addLesson(int courseId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce Name of the lesson: \n");
        String topic = scanner.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        String description = scanner.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        String paragraph = scanner.nextLine();
        int lessonOrder = lessons.stream()
                .filter(lesson -> lesson.getCourseId() == courseId)
                .mapToInt(Lesson::getLessonOrder)
                .max().getAsInt() + 1;
        int lessonNewId = lessons.getLast().getId() + 1;
        lessons.add( new Lesson(lessonNewId, lessonOrder, topic, description, paragraph, courseId));
        return lessonNewId;
    }

    @Override
    public void updateLesson(int courseId, int lessonId) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce Name of the lesson: \n");
        String topic = scanner.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        String description = scanner.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        String paragraph = scanner.nextLine();
        int indexOfLesson = lessons.indexOf(lessons.get(courseId));
        int orderId = lessons.get(indexOfLesson).getLessonOrder();
        Lesson newLesson = new Lesson(lessonId, orderId, topic, description, paragraph, courseId);
        lessons.set(indexOfLesson, newLesson);
        System.out.println("\n Lesson is updated!");
    }

    @Override
    public void removeLessonById(int courseId) {
        lessons.removeIf(lesson -> lesson.getCourseId() == courseId);
        System.out.println("\n Lesson is deleted!");

    }
}
