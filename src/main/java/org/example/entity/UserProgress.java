package org.example.entity;

public class UserProgress {
    private int id;
    private int userId;
    private int courseId;
    private int progressLessonCounter;

    public UserProgress() {
    }

    public UserProgress(int userId, int courseId, int progressLessonCounter) {
        this.userId = userId;
        this.courseId = courseId;
        this.progressLessonCounter = progressLessonCounter;
    }

    public UserProgress(int userId, int courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "UserProgress{" +
                "user=" + userId +
                ", id=" + id +
                ", courseId=" + courseId +
                ", progressLessonCounter=" + progressLessonCounter +
                '}';
    }
}


