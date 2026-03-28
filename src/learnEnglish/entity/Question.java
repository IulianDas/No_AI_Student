package learnEnglish.entity;

import java.util.Arrays;

public class Question {

    private  int id;
    private String question;
    private int answer;
    private String[] variant;
    private int quizId;

    public Question(int id, String question, int answer, String[] variant, int quizId) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.variant = variant;
        this.quizId = quizId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String[] getVariant() {
        return variant;
    }

    public void setVariant(String[] variant) {
        this.variant = variant;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", variant=" + Arrays.toString(variant) +
                '}';
    }
}
