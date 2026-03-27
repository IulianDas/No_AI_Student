package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.repository.QuestionRepository;

import java.util.Arrays;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private static String[] variants = {"I am a Jira","I am a Pisos","I am a Human","I am Dolbich"};
    private static Question questionHardcoded = new Question(41001, "Who are you?","I am a Human", variants, false, 1);
    private static List<Question> questions = Arrays.asList(questionHardcoded);

    @Override
    public Question getQuestion() {
        return null;
    }

    @Override
    public void setQuestion() {

    }

    @Override
    public List<Question> getAllQuestion() {
        return questions;
    }
}
