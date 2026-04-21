package org.example.entity;

import java.util.List;

public class Lesson {

    private int id;
    private int lessonOrder;
    private String topic;
    private String description;
    private String paragraph;
    private List<Question> questions;
    private int courseId;

    public Lesson(int id, int lessonOrder, String topic, String description, String paragraph, int courseId) {
        this.id = id;
        this.lessonOrder = lessonOrder;
        this.topic = topic;
        this.description = description;
        this.paragraph = paragraph;
        this.courseId = courseId;
    }

    public Lesson(int id, int lessonOrder, String topic, int courseId) {
        this.id = id;
        this.lessonOrder = lessonOrder;
        this.topic = topic;
        this.courseId = courseId;
    }

    public Lesson(int lessonOrder, String topic, String description, String paragraph, int courseId ) {
        this.lessonOrder = lessonOrder;
        this.topic = topic;
        this.description = description;
        this.paragraph = paragraph;
        this.courseId = courseId;
    }

    public Lesson() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLessonOrder() {
        return lessonOrder;
    }

    public void setLessonOrder(int lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonOrder=" + lessonOrder +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", paragraph='" + paragraph + '\'' +
                ", questions=" + questions +
                ", courseId=" + courseId +
                '}';
    }
}
