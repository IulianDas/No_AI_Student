package learnEnglish.entity;

public class Lesson {

    private int id;
    private String topic;
    private String description;
    private String paragraph;
    private Quiz quiz;

    public Lesson(int id, String topic, String description, String paragraph, Quiz quiz) {
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.paragraph = paragraph;
        this.quiz = quiz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
