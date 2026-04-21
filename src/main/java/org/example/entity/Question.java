package org.example.entity;

import java.util.List;

public class Question {

    private  int id;
    private String question;
    private int rightAnswer;
    private List<Answer> variant;
    private int quizId;

    public Question() {
    }

    public Question(int id, String question, int rightAnswer, List<Answer> variant, int quizId) {
        this.id = id;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variant = variant;
        this.quizId = quizId;
    }
    public Question(String question, int rightAnswer, List<Answer> variant, int quizId) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.variant = variant;
        this.quizId = quizId;
    }

    public Question(String question, int rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
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

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<Answer> getVariant() {
        return variant;
    }

    public void setVariant(List<Answer> variant) {
        this.variant = variant;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + rightAnswer +
                ", variant=" + variant +
                ", quizId=" + quizId +
                '}';
    }
}
