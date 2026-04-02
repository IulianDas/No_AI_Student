package learnEnglish.service.impl;

import learnEnglish.entity.Course;
import learnEnglish.entity.Lesson;
import learnEnglish.entity.Question;
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
        int courseId;
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
                    updateCourseName(courseId);
                    break;
                case 2:
                    updateCourseLesson(courseId);
                    break;
                case 3:
                    addLessonToExistingCourse(courseId);
                    break;
                case 4:
                    updateCourseQuiz(courseId);
                    break;
                case 0:
                    updateCicle = false;
                    break;
            }

        }
    }

    private void updateCourseQuiz(int courseId) {
        int lessonId;
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Quiz of what lesson you want to update: \n");
        lessonRepository.getLessonsByCourseId(courseId)
                .stream()
                .map(lesson -> "    Id: [" + lesson.getId() + "]\t order: [" + lesson.getTopic() + "]\n  name:" + lesson.getTopic() + "\n")
                .forEach(System.out::println);
        lessonId = scan.nextInt();
        int chosenQuizId = quizRepository.getQuizByLessonId(lessonId).getId();

        System.out.println("\n Introduce the new question: \n");
        String newQuestion = scan.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        String[] responseVariants = new String[4];
        for (int i = 0; i <= 3; i++){
            System.out.println("\n\t [" + i +"] ");
            responseVariants[i] = " "+i+")" + scan.nextLine();
        }
        System.out.println("\n Introduce number id of correct answer: \n");
        int answer = scan.nextInt();
        int questionId = questionRepository.getAllQuestion().stream().filter(question -> question.getQuizId() == chosenQuizId).findFirst().get().getId();
        int indexOfQuestion = questionRepository.getAllQuestion()
                .indexOf(questionRepository.getAllQuestion()
                .stream()
                .filter(question ->  question.getQuizId() == chosenQuizId)
                .findFirst().get());
        questionRepository.updateQuestion(indexOfQuestion, new Question(questionId, newQuestion, answer, responseVariants, chosenQuizId));
        System.out.println("\n Quiz is updated!");
    }

    private void updateCourseLesson(int courseId) {
        int lessonId, indexOfLesson, orderId;
        String topic, paragraph, description;
        Scanner scanLesson = new Scanner(System.in);

        lessonRepository.getLessonsByCourseId(courseId)
                .stream()
                .map(lesson -> "    Id: [" + lesson.getId() + "]\t order: [" + lesson.getLessonOrder() + "]\n  name:" + lesson.getTopic() + "\n")
                .forEach(System.out::println);
        System.out.println(" Chose lesson you want to modify (id): ");
        lessonId = scanLesson.nextInt();
        scanLesson.nextLine();
        System.out.println("\n Introduce Name of the lesson: \n");
        topic = scanLesson.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        description = scanLesson.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        paragraph = scanLesson.nextLine();
        indexOfLesson = lessonRepository.getLessons().indexOf(lessonRepository.getLessons().get(courseId));
        orderId = lessonRepository.getLessons().get(indexOfLesson).getLessonOrder();
        lessonRepository.updateLesson(indexOfLesson, new Lesson(lessonId, orderId, topic, description, paragraph, courseId));
        System.out.println("\n Lesson is updated!");
    }

    private void addLessonToExistingCourse(int courseId) {

        String topic, description, paragraph;
        int lessonOrder, lessonNewId, newQuizId, answer, questionNewId;
        Scanner scan = new Scanner(System.in);

        System.out.println("\n Introduce Name of the lesson: \n");
        topic = scan.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        description = scan.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        paragraph = scan.nextLine();
        lessonOrder = lessonRepository.getLessons().stream()
                .filter(lesson -> lesson.getCourseId() == courseId)
                .mapToInt(Lesson::getLessonOrder)
                .max().getAsInt() + 1;
        lessonNewId = lessonRepository.getLessons().getLast().getId() + 1;
        lessonRepository.createLesson(new Lesson(lessonNewId, lessonOrder, topic, description, paragraph, courseId));
        System.out.println("\n Lesson is created! \n");
        // Quiz and question generation
        newQuizId = quizRepository.getAllQuiz().getLast().getId()+1;
        quizRepository.createQuiz(new Quiz( newQuizId, lessonNewId));
        System.out.println("\n Introduce the question: \n");
        String question = scan.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        String[] responseVariants = new String[4];
        for (int i = 0; i <= 3; i++){
            System.out.println("\n\t [" + i +"] ");
            responseVariants[i] = " "+i+")" + scan.nextLine();
        }
        System.out.println("\n Introduce number id of correct answer: \n");
        answer = scan.nextInt();
        questionNewId = questionRepository.getAllQuestion().getLast().getId()+1;
        questionRepository.createQuestion( new Question(questionNewId,question, answer, responseVariants, newQuizId));
        System.out.println("\n Quiz with questions is created! \n");
    }

    private void updateCourseName(int courseId) {

        String newName;
        int indexPosition;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Introduce new Name for course: ");
        newName = sc.nextLine();
        indexPosition =courseRepository.getAllCourses().indexOf(courseRepository.getAllCourses().stream().filter(course -> course.getId() == courseId).findFirst().get());
        Course updatedCourse = courseRepository.getAllCourses().stream().filter(course -> course.getId() == courseId).findAny().get();
        updatedCourse.setName(newName);
        courseRepository.updateCourseName(indexPosition, updatedCourse);
        System.out.println("\n Name is changed!");
    }

    @Override
    public void createCourse() {

        int newCourseId, newLessonId, newQuizId, answer, questionNewId;
        String topic, description, paragraph, question;
        Scanner scanner = new Scanner(System.in);

        // Course generation
        System.out.println("\n Introduce name of the new course: ");
        String courseName = scanner.nextLine();
        newCourseId = courseRepository.getAllCourses().getLast().getId()+1;
        courseRepository.createNewCourse(new Course(newCourseId, courseName));
        System.out.println("\n Course is created! \n");

        // Lesson generation
        System.out.println("\n Introduce Name of the lesson: \n\n\n");
        topic = scanner.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        description = scanner.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        paragraph = scanner.nextLine();
        newLessonId = lessonRepository.getLessons().getLast().getId()+1;
        lessonRepository.createLesson( new Lesson(newLessonId, 1, topic, description, paragraph, newCourseId));
        System.out.println("\n Lesson is created! \n");

        // Quiz and question generation
        newQuizId = quizRepository.getAllQuiz().getLast().getId()+1;
        quizRepository.createQuiz(new Quiz( newQuizId, newLessonId));
        System.out.println("\n Introduce the question: \n");
        question = scanner.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        String[] responseVariants = new String[4];
        for (int i = 0; i <= 3; i++){
            System.out.println("\n\t [" + i +"] ");
            responseVariants[i] = " "+i+")" + scanner.nextLine();
        }
        System.out.println("\n Introduce number id of correct answer: \n");
        answer = scanner.nextInt();
        questionNewId = questionRepository.getAllQuestion().getLast().getId()+1;
        questionRepository.createQuestion( new Question(questionNewId,question, answer, responseVariants, newQuizId));
        System.out.println("\n Quiz with questions is created! \n");
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
