package org.example.entity;

public class Answer {

    private int id;
    private String variant;
    private int questionId;

    public Answer(String variant) {
        this.variant = variant;
    }

    public Answer() {
    }

    public Answer (int id, String variant) {
        this.id = id;
        this.variant = variant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", variant='" + variant + '\'' +
                ", questionId=" + questionId +
                '}';
    }
}
