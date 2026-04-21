package org.example;

import org.example.DB.DBConfig;
import org.example.util.Util;
import org.example.util.impl.UtilImpl;
import org.example.repository.*;
import org.example.repository.impl.*;
import org.example.service.*;
import org.example.service.impl.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final UserRepository userRepository;
    private static final CourseRepository courseRepository;
    private static final LessonRepository lessonRepository;
    private static final QuestionRepository questionRepository;
    private static final AnswerRepository answerRepository;
    private static final UserProgressRepository userProgressRepository;
    static {
        try {
            userRepository = new UserRepositoryImpl();
            courseRepository = new CourseRepositoryImpl();
            lessonRepository = new LessonRepositoryImpl();
            questionRepository = new QuestionRepositoryImpl();
            answerRepository = new AnswerRepositoryImpl();
            userProgressRepository = new UserProgressRepositoryImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final DBConfig controllerDB = new DBConfig();

    private static final UserProgressService userProgressService = new UserProgressServiceImpl(userProgressRepository);
    private static final QuestionService QUESTION_SERVICE = new QuestionServiceImpl(questionRepository, answerRepository,userProgressService);
    private static final Util resource = new UtilImpl();
    private static final CourseService courseService = new CourseServiceImpl(lessonRepository,userProgressRepository, QUESTION_SERVICE,courseRepository);
    private static final AdminService adminService = new AdminServiceImpl(courseRepository,lessonRepository, answerRepository,questionRepository, userProgressRepository);
    private static final CourseMenu courseMenu = new CourseMenuImpl(courseService);
    private static final AdminMenu adminMenu = new AdminMenuImpl(adminService);

    private static final UserService userService = new UserServiceImpl(userRepository, courseMenu, adminMenu,resource);


    public static void main(String[] args) throws SQLException {

        boolean tokenMenu = true;

        while (tokenMenu){
            System.out.print("\n--------- English Lesson -----------\n"
                    +"\t\n"
                    +"\t\t1) Login\n"
                    +"\t\t2) Register\n"
                    +"\t\t0) Exit\n"
                    +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChose = menu.nextInt();
            switch (menuChose) {
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
        }
    }

}