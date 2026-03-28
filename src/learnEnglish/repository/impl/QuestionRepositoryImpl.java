package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.repository.QuestionRepository;

import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private static final String[] variants = {"0) I am a Jira","1) I am a Ramen","2) I am a Human","3) I am USA Navy"};
    private static final Question questionHardcoded = new Question(41001, "Who are you?",2, variants, 1);
    private static final List<Question> questions = List.of(questionHardcoded);

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

    @Override
    public List<Question> getAllQuestionByQuizzId(int id) {
        return questions.stream().filter(question -> question.getQuizId() == id).toList();
    }
}
