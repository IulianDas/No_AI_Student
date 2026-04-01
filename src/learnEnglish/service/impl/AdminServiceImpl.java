package learnEnglish.service.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.CourseRepository;
import learnEnglish.repository.LessonRepository;
import learnEnglish.repository.QuestionRepository;
import learnEnglish.repository.QuizRepository;
import learnEnglish.service.AdminService;

import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public AdminServiceImpl(CourseRepository courseRepository, LessonRepository lessonRepository,QuizRepository quizRepository, QuestionRepository questionRepository  ) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.quizRepository = quizRepository;
        this. questionRepository= questionRepository;
    }

    @Override
    public void updateSelectedCourse() {

        Scanner scanner = new Scanner(System.in);
        boolean updateCicle = true;
        int courseId, lessonId;
        System.out.println("\n Chose course to update:\n");
        courseId = scanner.nextInt();

        while (updateCicle) {

            System.out.println("\n---------- Update Menu ------------\n" +
                    "\n What you want to update: " +
                    "\n\t 1) Course Name" +
                    "\n\t 2) Course lessons" +
                    "\n\t 3) Add lessons" +
                    "\n\t 4) Lesson quiz" +
                    "\n 0) Back to Menu" +
                    "\n------------------------------------\n");

            int choseWhatToUpdate = scanner.nextInt();
            switch (choseWhatToUpdate) {
                case 1:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("\n Introduce new Name for course: ");
                    String newName = sc.nextLine();
                    courseRepository.updateCourseName(courseId,newName);
                    break;
                case 2:
                    lessonRepository.getLessonsByCourseId(courseId)
                            .stream()
                            .map(lesson -> "    Id: [" + lesson.getId() + "]\t order: [" + lesson.getLessonOrder() + "]\n  name:" + lesson.getTopic() + "\n")
                            .forEach(System.out::println);
                    System.out.println(" Chose lesson you want to modify (id): ");
                    lessonId = scanner.nextInt();
                    lessonRepository.updateLesson(courseId, lessonId);
                    break;
                case 3:
                    lessonId = lessonRepository.addLesson(courseId);
                    lessonId = quizRepository.createQuiz(lessonId);
                    questionRepository.createQuestion(lessonId);
                    break;
                case 4:
                    System.out.println("\n Quiz of what lesson you want to update: \n");
                    lessonRepository.getLessonsByCourseId(courseId)
                            .stream()
                            .map(lesson -> "    Id: [" + lesson.getId() + "]\t order: [" + lesson.getTopic() + "]\n  name:" + lesson.getTopic() + "\n")
                            .forEach(System.out::println);
                    lessonId = scanner.nextInt();
                    Quiz chosenQuiz = quizRepository.getQuizByLessonId(lessonId);
                    questionRepository.updateQuestion(chosenQuiz.getId());
                    break;
                case 0:
                    updateCicle = false;
                    break;
            }

        }
    }

    @Override
    public void createCourse() {
        int id = courseRepository.createNewCourse();
        id = lessonRepository.createLesson(id);
        id = quizRepository.createQuiz(id);
        questionRepository.createQuestion(id);
    }

    @Override
    public void deleteCourseById(int courseId) {
        courseRepository.removeCourse(courseId);
        List<Lesson> listToDelete = lessonRepository.getLessonsByCourseId(courseId);
        lessonRepository.removeLessonById(courseId);
        for (Lesson lesson : listToDelete){
            Quiz currentQuiz = quizRepository.getQuizByLessonId(lesson.getId());
                questionRepository.removeQuestion(currentQuiz.getId());
                quizRepository.removeQuiz(lesson.getId());
        }
    }

    @Override
    public void getAllCourses() {
        courseRepository.getAllCourses()
                .stream()
                .map(course -> " Course: [" + course.getId() +"]\n" +
                        "\t Course Name: " + course.getName() + "\n")
                .forEach(System.out::println);
    }

}
