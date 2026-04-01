package learnEnglish.service.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuestionRepository;
import learnEnglish.repository.QuizRepository;
import learnEnglish.service.QuizService;
import learnEnglish.service.UserProgressService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final UserProgressService userProgressService;

    public QuizServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository, UserProgressService userProgressService) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.userProgressService = userProgressService;
    }

    @Override
    public void startQuiz(Lesson chosenLessonQuiz, int userId){

        Scanner scanner = new Scanner(System.in);
        int correctAnswerCounter = 0;
        boolean isCourseNotPassed = true;

        while (isCourseNotPassed) {
            quizRepository.getAllQuiz().stream()
                    .filter(quiz -> quiz.getLessonId() == chosenLessonQuiz.getId())
                    .map(quiz -> " Quiz of lesson " +quiz.getLessonId()+": \n"+
                            "\tQuiz number [" + quiz.getId() + "]\n" )
                    .forEach(System.out::println);

                //Simulating process of CLS: Clearing console before quiz
                System.out.println("\n\n\n\n" +
                                   "------- Lesson " + chosenLessonQuiz.getLessonOrder() +
                                   " Quiz ---------\n\n");
                Quiz lessonQuiz = quizRepository.getQuizByLessonId(chosenLessonQuiz.getId());
                List<Question> lessonQuestions = questionRepository.getAllQuestionByQuizId(lessonQuiz.getId());
                for (Question question : lessonQuestions) {
                    System.out.println(" Question is:\t " + question.getQuestion());
                    System.out.println("\n Chose answer:\n\t " );
                    Arrays.stream(question.getVariant()).map(s -> s + "\n").forEach(System.out::println);
                    System.out.println("\n\n\n\n\n\n\n");
                    int response = scanner.nextInt();
                    if (response == question.getAnswer()) {
                        System.out.println(" Yes, you are right!!!");
                        correctAnswerCounter +=1;
                    } else {
                        System.out.println(" Why are you running, chill and think twice!");
                    }
                }
                if(100 * correctAnswerCounter/lessonQuestions.size() >= 80) {
                    System.out.println("\n You Pass Lesson " + chosenLessonQuiz.getTopic());
                    userProgressService.updateUserProgress(userId,chosenLessonQuiz);
                    isCourseNotPassed = false;
                } else {
                System.out.println("\n You Failed Lesson " + chosenLessonQuiz.getTopic() + "\n");
                isCourseNotPassed = false;
            }

        }
    }

}
