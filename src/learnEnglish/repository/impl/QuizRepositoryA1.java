package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuizRepository;

public class QuizRepositoryA1 implements QuizRepository {

    private Question question;

    private static String[] variants = {"I am a Jira","I am a Pisos","I am a Human","I am Dolbich"};
    private static Question questionHardcoded = new Question(41001, "Who are you?","I am a Human", variants, false);
    private static Quiz quizA1Lesson1 = new Quiz(41000, questionHardcoded);


    @Override
    public Quiz getQuiz() {
        return quizA1Lesson1;
    }

    @Override
    public void setQuiz() {

    }
}
