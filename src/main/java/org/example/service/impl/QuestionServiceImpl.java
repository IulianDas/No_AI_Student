package org.example.service.impl;

import org.example.entity.Lesson;
import org.example.entity.Question;
import org.example.entity.UserProgress;
import org.example.repository.AnswerRepository;
import org.example.repository.QuestionRepository;
import org.example.service.QuestionService;
import org.example.service.UserProgressService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserProgressService userProgressService;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository, UserProgressService userProgressService) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userProgressService = userProgressService;
    }

    @Override
    public void startQuiz(Lesson chosenLessonQuiz, int userId) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int correctAnswerCounter = 0;
        boolean isCourseNotPassed = true;

        while (isCourseNotPassed) {
            List<Question> lessonQuestions = questionRepository.getAllQuestionByLessonId(chosenLessonQuiz.getId());
            for (Question question : lessonQuestions){
                question.setVariant(answerRepository.getAnswersByQuestionId(question.getId()));
            }
            lessonQuestions
                    .stream()
                    .map(question -> " Question of lesson: " + chosenLessonQuiz.getTopic()+" \n"+
                            "\t Question number [" + question.getId() + "]\n" )
                    .forEach(System.out::println);

                //Simulating process of CLS: Clearing console before quiz
                System.out.println("\n\n\n\n" +
                                   "------- Lesson " + chosenLessonQuiz.getLessonOrder() + " Quiz ---------\n\n");

                for (Question question : lessonQuestions) {
                    System.out.println(" Question is:\t " + question.getQuestion());
                    System.out.println("\n Chose answer:\n\t " );
                    question.getVariant().stream().map(answer -> answer.getVariant() + "\n").forEach(System.out::println);
                    System.out.println("\n\n\n\n\n\n\n");
                    int response = scanner.nextInt();
                    if (response == question.getRightAnswer()) {
                        System.out.println(" Yes, you are right!!!");
                        correctAnswerCounter +=1;
                    } else {
                        System.out.println(" Why are you running, chill and think twice!");
                    }
                }
                if(100 * correctAnswerCounter/lessonQuestions.size() >= 80) {
                    System.out.println("\n You Pass Lesson " + chosenLessonQuiz.getTopic());
                    userProgressService.updateUserProgress( new UserProgress(userId,chosenLessonQuiz.getCourseId(), 1));
                    isCourseNotPassed = false;
                } else {
                System.out.println("\n You Failed Lesson " + chosenLessonQuiz.getTopic() + "\n");
                isCourseNotPassed = false;
            }

        }
    }

}
