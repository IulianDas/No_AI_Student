package learnEnglish.entity;

import java.util.List;

public class Quiz {

    private int id;
    private List<Question> questions;
    private int lessonId;

    public Quiz() {
    }

    public Quiz(int id, int lessonId) {
        this.id = id;
        this.lessonId = lessonId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", questions=" + questions +
                ", lessonId" + lessonId +
                '}';
    }
}
