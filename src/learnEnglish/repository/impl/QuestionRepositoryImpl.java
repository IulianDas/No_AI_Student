package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {

    private static final List<Question> questions = new ArrayList<>();

    public QuestionRepositoryImpl() {
        questions.add(new Question(41001, "Who are you?",2, new String[]{"0) I am a Jira","1) I am a Ramen","2) I am a Human","3) I am USA Navy"}, 1));
        questions.add(new Question(41002, "Who are me?",1, new String[]{"0) I am a Calculator","1) I am a Machine","2) I am a Human","3) I am Moldova"}, 2));
        questions.add(new Question(42001, "What doing a man when he have a trouble?",2, new String[]{"0) Dancing in a moon light","1) Buy ticket to space","2) Think obout solution","3) Play with the indians"}, 3));
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
