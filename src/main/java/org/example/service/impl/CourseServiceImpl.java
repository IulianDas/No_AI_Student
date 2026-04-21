package org.example.service.impl;

import org.example.entity.Course;
import org.example.entity.Lesson;
import org.example.entity.UserProgress;
import org.example.repository.CourseRepository;
import org.example.repository.LessonRepository;
import org.example.repository.UserProgressRepository;
import org.example.service.CourseService;
import org.example.service.QuestionService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {

    private final LessonRepository lessonRepository;
    private final UserProgressRepository userProgressRepository;
    private final QuestionService questionService;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(LessonRepository lessonRepository, UserProgressRepository userProgressRepository, QuestionService questionService, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.userProgressRepository = userProgressRepository;
        this.questionService = questionService;
        this.courseRepository = courseRepository;
    }

    public void startLesson(int userId) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int lessonId;
        int courseId;
        List<Lesson> lessons;
        System.out.println("\t Back to Menu  [0] \n"
                + "Enter id: \n");
        courseId = scanner.nextInt();
        if (courseId != 0) {
            while (true) {
                System.out.println("------- English new Courses ---------\n");
                lessons = lessonRepository.getLessonsByCourseId(courseId);
                UserProgress userProgress = userProgressRepository.getCourseProgressByUserIdAndCourseId(userId, courseId);

                if (userProgress != null) {
                    lessons.stream()
                            .filter(lesson -> lesson.getLessonOrder() > userProgress.getProgressLessonCounter())
                            .toList().stream()
                            .map(lesson -> " Lesson [" + lesson.getLessonOrder() + "]" +
                                    "\n Topic:\t" + lesson.getTopic() + "\n")
                            .forEach(System.out::println);
                } else {
                    lessons.stream()
                            .map(lesson -> " Lesson [" + lesson.getLessonOrder() + "]" +
                                    "\n Topic:\t" + lesson.getTopic() + "\n")
                            .forEach(System.out::println);
                }
                System.out.println("\t Back to Menu  [0] \n"
                        + "\n Enter lesson id:\n");
                lessonId = scanner.nextInt();
                if (lessonId != 0) {
                    int finalLessonId = lessonId;
                    Lesson chosenLesson = lessons.stream().filter(lesson -> lesson.getLessonOrder() == finalLessonId).findAny().orElseGet(Lesson::new);
                    System.out.println(" Description: \n " + chosenLesson.getDescription()
                            + "\n " + chosenLesson.getParagraph()
                            + "\n\n\n");
                    System.out.println(" Input 1 to start quiz or 0 to exit.\n\n\n\n");
                    if (scanner.nextInt() != 0) {
                        questionService.startQuiz(chosenLesson, userId);

                    } else {
                        break;
                    }
                } else {
                    break;
                }
                System.out.println(" Do you want to continue with next lesson?\n" +
                        "\t 1) Chose next lesson.\n" +
                        "\t 0) Exit Course ");
                if (scanner.nextInt() == 0) {
                    break;
                }
            }
        }
    }


    @Override
    public void getAllCourses() throws SQLException {
        courseRepository.getAllCourses()
                .stream()
                .map(course -> " Course: [" + course.getId() + "]\n" +
                        "\t Course Name " + course.getName() + "\n")
                .forEach(System.out::println);
    }

    @Override
    public void getUserProgress(int userId) throws SQLException {
        if (userProgressRepository.getCourseProgressByUserId(userId).isEmpty()) {
            System.out.println("\n You don't have any progress!\n\t");
        } else {
            System.out.println("\n Progress of user is:\n\t");
            List<UserProgress> userProgresses = userProgressRepository.getCourseProgressByUserId(userId);
            for (UserProgress userProgress : userProgresses) {
                int courseId = userProgress.getCourseId();
                System.out.println("Course:\n\t ["
                        + courseId
                        + "] "
                        + courseRepository.getCourse(courseId).getName()
                        + "\n\t Is passed on: "
                        + (double) (userProgress.getProgressLessonCounter()) / courseRepository.getCourse(userProgress.getCourseId()).getLessons().size() * 100
                        + "%\n");
            }

        }
    }

    @Override
    public List<Integer> getCourseListByUsersId(int userId) throws SQLException {
        return userProgressRepository.getCourseProgressByUserId(userId)
                .stream()
                .map(UserProgress::getCourseId)
                .toList();
    }

    public Course getCourseById(int courseId) throws SQLException {
        return courseRepository.getCourse(courseId);
    }

    @Override
    public void getStartedCourses(List<Course> courses) {
        courses.stream()
                .map(course -> " Course: [" + course.getId() + "]\n" +
                        "\t Course Name " + course.getName() +
                        "\n")
                .forEach(System.out::println);
    }

}
