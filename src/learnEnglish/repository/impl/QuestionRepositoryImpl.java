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
        questions.add(new Question(42002, "What doing a women when she goes?",0, new String[]{"0) Dancing in a moon light(is right)","1) Cry tonight","2) Think obout solution","3) Play with the indians"}, 4));
    }

    @Override
    public void createQuestion(Question newQuestion) {
        questions.add( newQuestion);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questions;
    }

    @Override
    public List<Question> getAllQuestionByQuizId(int id) {
        return questions.stream().filter(question -> question.getQuizId() == id).toList();
    }

    @Override
    public void removeQuestion(int quizId) {
        questions.removeIf(question -> question.getQuizId() == quizId);
        System.out.println("\n Questions are deleted!");
    }

    @Override
    public void updateQuestion(int indexPosition, Question updatedQuestion) {
        questions.set(indexPosition, updatedQuestion);

    }
}
