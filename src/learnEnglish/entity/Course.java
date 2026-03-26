package learnEnglish.entity;

import java.util.List;

public class Course {

    private int id;
    private String name;
    private List<Lesson> lessons;

    public Course(int id, String name, List<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.lessons = lessons;
    }

    public Course() {

    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
