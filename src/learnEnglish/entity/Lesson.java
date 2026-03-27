package learnEnglish.entity;

public class Lesson {

    private int id;
    private String topic;
    private String description;
    private String paragraph;
    private Quiz quiz;
    private int courseId;

    public Lesson(int id, String topic, String description, String paragraph, int courseId) {
        this.id = id;
        this.topic = topic;
        this.description = description;
        this.paragraph = paragraph;
        this.courseId = courseId;
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
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", paragraph='" + paragraph + '\'' +
                ", quiz=" + quiz +
                '}';
    }
}
