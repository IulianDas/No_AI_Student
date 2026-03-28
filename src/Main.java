import learnEnglish.entity.Course;
import learnEnglish.entity.Lesson;
import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.*;
import learnEnglish.repository.impl.*;
import learnEnglish.resources.Resource;
import learnEnglish.resources.impl.ResourceImpl;
import learnEnglish.service.*;
import learnEnglish.service.impl.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final CourseRepository courseRepository = new CourseRepositoryImpl();
    private static final LessonRepository lessonRepository = new LessonRepositoryImpl();
    private static final QuestionRepository questionRepository = new QuestionRepositoryImpl();
    private static final QuizRepository quizRepository = new QuizRepositoryImpl();
    private static final UserProgressRepository userProgressRepository = new UserProgressRepositoryImpl();

    private static final UserProgressService userProgressService = new UserProgressServiceImpl(userProgressRepository);
    private static final QuizService quizService = new QuizServiceImpl(questionRepository, quizRepository);
    private static final AdminMenu adminMenu = new AdminMenuImpl();
    private static final Resource resource = new ResourceImpl();
    private static final CourseService courseService = new CourseServiceImpl(lessonRepository,userProgressRepository,quizService,userProgressService);
    private static final CourseMenu courseMenu = new CourseMenuImpl(courseRepository, userProgressRepository,courseService);

    private static final UserService userService = new UserServiceImpl(userRepository, courseMenu, adminMenu,resource);

    public static void main(String[] args) {

        //ToDO Eto esheo siroi proekt

        initDB();

        boolean tokenMenu = true;

        while (tokenMenu){
        System.out.print("\n--------- English Lesson -----------\n"
                +"\t\n"
                +"\t\t1) Login\n"
                +"\t\t2) Register\n"
                +"\t\t0) Exit\n"
                +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();
            switch (menuChoise) {
                case 1:
                    userService.authentication();
                    break;
                case 2:
                    userService.registration();
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }
        /*SyntaxMenu syntaxMenu = new SyntaxMenu();
        OOP oopMenu = new OOP();
        boolean tokenMenu = true;

        while (tokenMenu){
            System.out.print("\n------------ Main Menu -------------\n" +
                    "\tChose exercise to test:\n" +
                    "\t\t1) Exercise One with Java Syntax\n" +
                    "\t\t2) Exercise Two with OOP Principles\n" +
                    "\t\t0) Exit" +
                    "\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();

            switch (menuChoise) {
                case 1:
                    syntaxMenu.syntaxMenu();
                    break;
                case 2:
                    oopMenu.oopMenu();
                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }
        }*/
    }
    }

    public static void initDB(){
        List<Course> courses = courseRepository.getAllInit();
        List<Lesson> lessons = lessonRepository.getLessons();
        List<Quiz> quizzes = quizRepository.getAllQuiz();
        List<Question> questions = questionRepository.getAllQuestion();

        courses.stream()
                .peek(course -> course.setLessons(lessons.stream()
                        .peek(lesson -> lesson.setQuiz(quizzes.stream()
                                .peek(quiz -> quiz.setQuestions(questions.stream()
                                        .filter(question -> question.getQuizId() == quiz.getId())
                                        .toList()))
                                .filter(quiz -> quiz.getLessonId() == lesson.getId() )
                                .findFirst().orElseGet(Quiz::new)))
                        .filter(lesson -> lesson.getCourseId() == course.getId())
                        .toList()))
                .toList();
    }

}