package learnEnglish.service.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuestionRepository;
import learnEnglish.repository.QuizRepository;
import learnEnglish.service.QuizService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizServiceImpl implements QuizService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public void startQuiz(Lesson chosenLessonQuiz){

        Scanner scanner = new Scanner(System.in);
        int correctAnswerCounter = 0;
        boolean isCourseNotPassed = true;

        while (isCourseNotPassed) {

            System.out.println(chosenLessonQuiz);
            System.out.println("\n Input 1 to start quiz or 0 to exit.");
            if (scanner.nextInt() == 1) {
                System.out.println(quizRepository.getAllQuiz());
                Quiz lessonQuiz = quizRepository.getQuizByLessonId(chosenLessonQuiz.getId());
                List<Question> lessonQuestions = questionRepository.getAllQuestionByQuizzId(lessonQuiz.getId());
                for (Question question : lessonQuestions) {
                    System.out.println(" Question is:\n " + question.getQuestion());
                    System.out.println(" Chose answer:\n " + Arrays.toString(question.getVariant()));
                    int response = scanner.nextInt();
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
    }

}
