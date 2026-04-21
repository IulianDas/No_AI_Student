package org.example.service.impl;

import org.example.entity.*;
import org.example.repository.*;
import org.example.service.AdminService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserProgressRepository userProgressRepository;

    public AdminServiceImpl(CourseRepository courseRepository, LessonRepository lessonRepository, AnswerRepository answerRepository, QuestionRepository questionRepository, UserProgressRepository userProgressRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userProgressRepository = userProgressRepository;
    }

    @Override
    public void updateSelectedCourse() throws SQLException {

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
                    "\n\t 3) Lessons Quiz" +
                    "\n\t 4) Add Lesson to Course" +
                    "\n\t 5) Add Question to Lesson" +
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
                    updateLessonQuiz(courseId);
                    break;
                case 4:
                    addLessonToExistingCourse(courseId);
                    break;
                case 5:
                    System.out.println("\n Question to what lesson you want to add: \n");
                    lessonRepository.getLessonsByCourseId(courseId)
                            .stream()
                            .map(lesson -> "    Id: [" + lesson.getId() + "]\t \n  name:" + lesson.getTopic() + "\n")
                            .forEach(System.out::println);
                    int lessonId = scanner.nextInt();
                    addQuestionToLesson(lessonId);
                    break;
                case 0:
                    updateCicle = false;
                    break;
            }

        }
    }


    private void updateLessonQuiz(int courseId) throws SQLException {
        int lessonId, questionId;
        String newQuestion, variants;
        List<Answer> responseVariants = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("\n Question of what lesson you want to update: \n");
        lessonRepository.getLessonsByCourseId(courseId)
                .stream()
                .map(lesson -> "    Id: [" + lesson.getId() + "]\t order: [" + lesson.getTopic() + "]\n  name:" + lesson.getTopic() + "\n")
                .forEach(System.out::println);
        lessonId = scan.nextInt();
        questions = questionRepository.getAllQuestionByLessonId(lessonId);
        System.out.println("\n Introduce the number of question that you want to update: \n");
        questions.stream()
                .map(question -> "    Id: [" + question.getQuizId() + "] " + question.getQuestion())
                .forEach(System.out::println);
        ;
        questionId = scan.nextInt();
        System.out.println("\n\n -------- Update Chosen Question -------- \n");
        System.out.println("\n\n Introduce the new question: \n");
        newQuestion = scan.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        for (int i = 1; i <= 4; i++) {
            System.out.println("\n\t [" + i + "] ");
            variants = i + ") " + scan.nextLine();
            responseVariants.add(new Answer(variants));
            variants = "";
        }
        System.out.println("\n Introduce number id of correct answer: \n");
        int answer = scan.nextInt();
        Question updatedQuestion = new Question(newQuestion, answer, responseVariants, questionId);
        questionRepository.updateQuestion(questionId, updatedQuestion);
        answerRepository.updateAnswersByQuestionId(questionId, responseVariants);
        System.out.println("\n Question is updated!");
    }

    private void updateCourseLesson(int courseId) throws SQLException {
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

    @Override
    public void createCourse() throws SQLException {

        int newCourseId;
        Scanner scanner = new Scanner(System.in);

        // Course generation
        System.out.println("\n Introduce name of the new course: ");
        String courseName = scanner.nextLine();
        newCourseId = courseRepository.createNewCourse(courseName);
        System.out.println("\n Course is created! \n");

        addLessonToExistingCourse(newCourseId);

    }

    private void addLessonToExistingCourse(int courseId) throws SQLException {

        String topic, description, paragraph;
        int lessonOrder, lessonNewId, saveInt;
        List<Lesson> lessons = lessonRepository.getLessonsByCourseId(courseId);
        Scanner scan = new Scanner(System.in);

        System.out.println("\n Introduce Name of the lesson: \n");
        topic = scan.nextLine();
        System.out.println("\n Introduce description of the lesson: \n");
        description = scan.nextLine();
        System.out.println("\n Introduce rules or additional information: \n");
        paragraph = scan.nextLine();
        System.out.println("\n\n\n You want to save this lesson and move to question?\n" +
                " [1] Yes\t\t\t[0] No\n");
        saveInt = scan.nextInt();
        if (saveInt != 0) {
            if (!lessons.isEmpty()) {
                lessonOrder = lessons.stream()
                        .filter(lesson -> lesson.getCourseId() == courseId)
                        .mapToInt(Lesson::getLessonOrder)
                        .max().getAsInt() + 1;
                lessonNewId = lessonRepository.createLesson(courseId, new Lesson(lessonOrder, topic, description, paragraph, courseId));
            } else {
                lessonNewId = lessonRepository.createLesson(courseId, new Lesson(1, topic, description, paragraph, courseId));
            }
            System.out.println("\n Lesson is created! \n");
            addQuestionToLesson(lessonNewId);
        }
    }

    private void addQuestionToLesson(int lessonNewId) throws SQLException {
        String variant;
        int newQuestionId, saveInt;
        int answer;
        List<Answer> responseVariants = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n\n ------Question generation------ \n");
        System.out.println("\n Introduce the question: \n");
        String question = scan.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        for (int i = 1; i <= 4; i++) {
            System.out.println("\n\t [" + i + "] ");
            variant = i + ") " + scan.nextLine();
            responseVariants.add(new Answer(variant));
            variant = "";
        }
        System.out.println("\n Introduce number of correct answer: \n");
        answer = scan.nextInt();

        System.out.println("\n\n\n You want to save this question?\n" +
                " [1] Yes\t\t\t[0] No\n");
        saveInt = scan.nextInt();
        if (saveInt != 0) {
            newQuestionId = questionRepository.createQuestion(lessonNewId, new Question(question, answer));
            for (Answer saveAnswer : responseVariants) {
                answerRepository.createAnswer(newQuestionId, saveAnswer);
            }
            System.out.println("\n Question is created! \n");
        }
    }

    private void updateCourseName(int courseId) throws SQLException {

        String newName;
        int indexPosition;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Introduce new Name for course: ");
        newName = sc.nextLine();
        indexPosition = courseRepository.getAllCourses().indexOf(courseRepository.getAllCourses().stream().filter(course -> course.getId() == courseId).findFirst().get());
        Course updatedCourse = courseRepository.getAllCourses().stream().filter(course -> course.getId() == courseId).findAny().get();
        updatedCourse.setName(newName);
        courseRepository.updateCourseName(indexPosition, updatedCourse);
        System.out.println("\n Name is changed!");
    }


    @Override
    public void deleteCourseById(int courseId) throws SQLException {

        List<Lesson> lessons = lessonRepository.getLessonsByCourseId(courseId);
        for (Lesson lesson : lessons) {
            List<Question> questions = questionRepository.getAllQuestionByLessonId(lesson.getId());
            for (Question question : questions) {
                List<Answer> answers = answerRepository.getAnswersByQuestionId(question.getId());
                for (Answer answer : answers) {
                    answerRepository.deleteAnswer(question.getId(), answer.getId());
                }
                questionRepository.removeQuestion(lesson.getId(), question.getQuizId());
            }
            lessonRepository.removeLessonById(courseId, lesson.getId());

        }
        courseRepository.removeCourse(courseId);
        userProgressRepository.deleteCourseProgress(courseId);
    }

    @Override
    public void getAllCourses() throws SQLException {
        courseRepository.getAllCourses()
                .stream()
                .map(course -> " Course: [" + course.getId() + "]\n" +
                        "\t Course Name: " + course.getName() + "\n")
                .forEach(System.out::println);
    }

}
