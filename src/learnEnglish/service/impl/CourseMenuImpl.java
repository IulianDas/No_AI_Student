package learnEnglish.service.impl;

import learnEnglish.entity.*;
import learnEnglish.repository.*;
import learnEnglish.service.CourseMenu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseMenuImpl implements CourseMenu {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final UserProgressRepository userProgressRepository;

    public CourseMenuImpl(CourseRepository courseRepository, LessonRepository lessonRepository, QuestionRepository questionRepository, QuizRepository quizRepository, UserProgressRepository userProgressRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.userProgressRepository = userProgressRepository;
    }

    @Override
    public void getCourseMenu(final User user) {

        int courseId;
        int lessonId;
        List<Lesson> lessons;
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
                    System.out.println(courseRepository.getAllCourses());
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("------- English new Courses ---------\n"+
                                       "\n Enter curs id:\n");
                    courseId = menu.nextInt();
                    lessons = lessonRepository.getLessonsByCourseId(courseId);
                    boolean startNewCourse = true;

                    while (startNewCourse) {

                        int correctAnswerCounter = 0;
                        boolean isCourseNotPassed = true;
                        //lessons.sort(Comparator.comparingInt(Lesson::getLessonOrder));
                        System.out.println(lessons);
                        System.out.println("\n Enter lesson id:\n");
                        lessonId = menu.nextInt();
                        int finalLessonId = lessonId;
                        Lesson chosenLesson = lessons.stream().findFirst().filter(lesson -> lesson.getId() == finalLessonId).orElseGet(Lesson::new);

                        while (isCourseNotPassed) {

                            System.out.println(chosenLesson);
                            System.out.println("\n Input 1 to start quiz or 0 to exit.");
                            if (menu.nextInt() == 1) {
                                Quiz lessonQuiz = quizRepository.getQuizByLessonId(lessonId);
                                List<Question> lessonQuestions = questionRepository.getAllQuestionByQuizzId(lessonQuiz.getId());
                                for (Question question : lessonQuestions) {
                                    System.out.println(" Question is:\n " + question.getQuestion());
                                    System.out.println(" Chose answer:\n " + Arrays.toString(question.getVariant()));
                                    int response = menu.nextInt();
                                    if (response == question.getAnswer()) {
                                        System.out.println(" Yes, you are right!!!");
                                        correctAnswerCounter +=1;
                                    } else {
                                        System.out.println(" Why are you running, chill and think twice!");
                                    }

                                }
                                if(100*correctAnswerCounter/lessonQuestions.size() >= 80) {
                                    isCourseNotPassed = false;
                                }
                            } else {
                                isCourseNotPassed = false;
                            }
                        }
                        UserProgress userProgress = new UserProgress();
                        if (chosenLesson.getLessonOrder() == 1) {
                            userProgressRepository.saveUserProgress(userProgress);
                        } else {
                            userProgressRepository.updateUserProgress(userProgress);
                        }
                        System.out.println("\n Do you want to continue with next lesson?\n\t 1) Chose next lesson.\n\t 0) Exit Course ");
                        if(menu.nextInt() == 0){
                            startNewCourse = false;
                        }
                    }
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
