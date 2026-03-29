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
    private final CourseRepository courseRepository;

    public CourseServiceImpl(LessonRepository lessonRepository, UserProgressRepository userProgressRepository, QuizService quizService, UserProgressService userProgressService, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.userProgressRepository = userProgressRepository;
        this.quizService = quizService;
        this.userProgressService = userProgressService;
        this.courseRepository = courseRepository;
    }

    public void startLesson(User user) {

        Scanner scanner = new Scanner(System.in);
        int lessonId;
        int courseId;
        List<Lesson> lessons;
        System.out.println("\t Back to Menu  [0] \n"
                          +"Enter id: \n");
        courseId = scanner.nextInt();
        if(courseId != 0) {

            System.out.println("------- English new Courses ---------\n");
            lessons = lessonRepository.getLessonsByCourseId(courseId);
            UserProgress userProgress = userProgressRepository.getCourseProgressByUserIdAndCourseId(user.getId(), courseId);
            boolean startNewCourse = true;

            while (startNewCourse) {
                //lessons.sort(Comparator.comparingInt(Lesson::getLessonOrder));
                lessons.stream()
                        .filter(lesson -> lesson.getLessonOrder() > userProgress.getProgressLessonCounter())
                        .toList().stream()
                        .map(lesson -> " Lesson [" + lesson.getLessonOrder() + "]" +
                                "\n Topic:\t" + lesson.getTopic() + "\n")
                        .forEach(System.out::println);
                System.out.println("\t Back to Menu  [0] \n"
                                 + "\n Enter lesson id:\n");
                lessonId = scanner.nextInt();
                if(lessonId != 0) {
                    int finalLessonId = lessonId;
                    Lesson chosenLessonQuiz = lessons.stream().filter(lesson -> lesson.getLessonOrder() == finalLessonId).findAny().orElseGet(Lesson::new);
                    System.out.println(" Description: \n " + chosenLessonQuiz.getDescription()
                            + "\n " + chosenLessonQuiz.getParagraph()
                            + "\n\n\n");
                    System.out.println(" Input 1 to start quiz or 0 to exit.\n\n\n\n");
                    if(scanner.nextInt() != 0){
                    quizService.startQuiz(chosenLessonQuiz, user);

                    System.out.println(" Do you want to continue with next lesson?\n" +
                            "\t 1) Chose next lesson.\n" +
                            "\t 0) Exit Course ");

                    if (scanner.nextInt() == 0) {
                        startNewCourse = false;
                    }
                } else {
                    startNewCourse = false;
                }
                }else {
                    startNewCourse = false;
                }
            }
        }
    }

    @Override
    public void getAllCourses(CourseRepository courseRepository) {
        courseRepository.getAllCourses()
                .stream()
                .map(course -> " Course: [" + course.getId() +"]\n" +
                                      "\t Course Name " + course.getName() + "\n")
                .forEach(System.out::println);
    }

    @Override
    public void getUserProgress(User user) {
        if (userProgressRepository.getLastId() == -1){
            System.out.println("\n You don't have any progress!:\n\t");
        }else {
            System.out.println("\n Progress of user is:\n\t");
            userProgressRepository.getCourseProgressByUserId(user.getId())
                .stream()
                .map(userProgress ->" Course:\n\t ["
                                                + courseRepository.getCourse(userProgress.getCourseId()).getId()+"] "
                                                + courseRepository.getCourse(userProgress.getCourseId()).getName()
                                                + "\n\t Is passed on "
                                                + ((double) userProgress.getProgressLessonCounter())/courseRepository.getCourse(userProgress.getCourseId()).getLessons().size()*100
                                                + "%\n")
                .forEach(System.out::println);
        }
    }

    @Override
    public List<Integer> getCourseListByUsersId(User user) {
        return userProgressRepository.getCourseProgressByUserId(user.getId())
                .stream()
                .map(UserProgress::getCourseId)
                .toList();
    }
@Override
    public List<Course> getCoursesByListId(List<Integer> ids) {
        return courseRepository.getAllCoursesByListId(ids);
    }

    @Override
    public void getStartedCourses(List<Course> courses) {
        courses.stream()
                .map(course -> " Course: [" + course.getId() +"]\n" +
                        "\t Course Name " + course.getName() +
                        "\n")
                .forEach(System.out::println);
    }

}
