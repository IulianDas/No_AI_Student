package learnEnglish.entity;

import java.util.List;

public class Quiz {

    private int id;
    private List<Question> questions;

    public Quiz(int id, Question questionHardcoded) {
        this.id = id;
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


}
