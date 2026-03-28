package learnEnglish.entity;

public class UserProgress {
    private User user;
    private int id;
    private int courseId;
    private int progressLessonCounter;
    private float percentProgress;

    public UserProgress() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getProgressLessonCounter() {
        return progressLessonCounter;
    }

    public void setProgressLessonCounter(int progressLessonCounter) {
        this.progressLessonCounter = progressLessonCounter;
    }

    public float getPercentProgress() {
        return percentProgress;
    }

    public void setPercentProgress(float percentProgress) {
        this.percentProgress = percentProgress;
    }

    @Override
    public String toString() {
        return "UserProgress{" +
                "user=" + user +
                ", id=" + id +
                ", courseId=" + courseId +
                ", progressLessonCounter=" + progressLessonCounter +
                ", percentProgress=" + percentProgress +
                '}';
    }
}


