package learnEnglish.service.impl;

import learnEnglish.entity.*;
import learnEnglish.repository.*;
import learnEnglish.service.CourseService;
import learnEnglish.service.QuizService;
import learnEnglish.service.UserProgressService;

import java.util.List;
import java.util.Scanner;

public class CourseServiceImpl implements CourseService {

    private final LessonRepository lessonRepository;

    private final UserProgressRepository userProgressRepository;
    private final QuizService quizService;
    private final UserProgressService userProgressService;

    public CourseServiceImpl(LessonRepository lessonRepository, UserProgressRepository userProgressRepository, QuizService quizService, UserProgressService userProgressService) {
        this.lessonRepository = lessonRepository;

        this.userProgressRepository = userProgressRepository;
        this.quizService = quizService;
        this.userProgressService = userProgressService;
    }

    public void startLesson(User user) {

        Scanner scanner = new Scanner(System.in);
        int lessonId;
        int courseId;
        List<Lesson> lessons;
        System.out.println("------- English new Courses ---------\n"+
                "\n Enter curs id:\n");
        courseId = scanner.nextInt();
        lessons = lessonRepository.getLessonsByCourseId(courseId);
        UserProgress userProgress1 = userProgressRepository.getCourseProgressByUserIdAndCourseId(user.getId(),courseId);
        boolean startNewCourse = true;

        while (startNewCourse) {


            //lessons.sort(Comparator.comparingInt(Lesson::getLessonOrder));
            lessons.stream().filter(lesson -> lesson.getLessonOrder()>userProgress1.getProgressLessonCounter()).toList().forEach(System.out::println);
            System.out.println("\n Enter lesson id:\n");
            lessonId = scanner.nextInt();
            int finalLessonId = lessonId;
            Lesson chosenLessonQuiz = lessons.stream().filter(lesson -> lesson.getId() == finalLessonId).findAny().orElseGet(Lesson::new);
            quizService.startQuiz(chosenLessonQuiz);
            userProgressService.updateUserProgress(user,chosenLessonQuiz);

            System.out.println("\n Do you want to continue with next lesson?\n\t 1) Chose next lesson.\n\t 0) Exit Course ");
            if(scanner.nextInt() == 0){
                startNewCourse = false;
            }
        }
    }


}
