package learnEnglish.service.impl;

import learnEnglish.entity.*;
import learnEnglish.repository.CourseRepository;
import learnEnglish.repository.LessonRepository;
import learnEnglish.repository.QuestionRepository;
import learnEnglish.repository.QuizRepository;
import learnEnglish.repository.impl.CourseRepositoryImpl;
import learnEnglish.repository.impl.LessonRepositoryImpl;
import learnEnglish.repository.impl.QuestionRepositoryImpl;
import learnEnglish.repository.impl.QuizRepositoryA1Impl;
import learnEnglish.service.CourseMenu;

import java.util.List;
import java.util.Scanner;

public class CourseMenuImpl implements CourseMenu {

    private CourseRepository courseRepository = new CourseRepositoryImpl();
    private LessonRepository lessonRepository = new LessonRepositoryImpl();
    private QuestionRepository questionRepository = new QuestionRepositoryImpl();
    private QuizRepository quizRepository = new QuizRepositoryA1Impl();

    public void initDB(){
        List<Course> courses = courseRepository.getAllInit();
        List<Lesson> lessons = lessonRepository.getLessons();
        List<Quiz> quizzes = quizRepository.getAllQuiz();
        List<Question> questions = questionRepository.getAllQuestion();

        List<Course> fullCourses = courses.stream()
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


        courseRepository.initDB(fullCourses);
    }

    @Override
    public void getCourseMenu(final User user) {

        Course curs;
        Lesson lesson;

        initDB();

        boolean tokenMenu = true;
        while (tokenMenu){
            System.out.print("\n--------- English Lesson -----------\n"
                    +"\t\n"
                    +"\t\t1) Get All Courses\n"
                    +"\t\t2) Continue\n"
                    +"\t\t3) Start New Course\n"
                    +"\t\t4) Check Progress\n"
                    +"\t\t0) Logout\n"
                    +"\n------------------------------------\n");

            Scanner menu = new Scanner(System.in);
            int menuChoise = menu.nextInt();
            switch (menuChoise) {
                case 1:
                    int courseId = menu.nextInt();
                    System.out.println(courseRepository.getAllCourses());
                    curs = courseRepository.getCourse(courseId);
                    System.out.println(curs.getId() + "" + curs.getName() + "" + curs.getLessons() );
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    tokenMenu = false;
                    break;
            }

    }
}
}
