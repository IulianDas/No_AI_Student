package org.example.entity;

import java.util.List;

public class Course {

    private int id;
    private String name;
    private List<Lesson> lessons;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lessons=" + lessons +
                '}';
    }
}
