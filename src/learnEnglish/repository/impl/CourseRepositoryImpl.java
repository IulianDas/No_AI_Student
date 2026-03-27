package learnEnglish.repository.impl;

import learnEnglish.entity.Course;

import java.util.Arrays;
import java.util.List;

public class CourseRepositoryImpl implements learnEnglish.repository.CourseRepository {

    private List<Course> courses;
    private static Course course = new Course(1,"Who are you lesson");
    private static List<Course> coursesToInit = Arrays.asList(course);

    public CourseRepositoryImpl() {
    }

    public void initDB(List<Course> courses){
        this.courses = courses;
    }

    @Override
    public Course getCourse(int courseId) {
        return courses.stream().findFirst().filter(course1 -> course1.getId() == courseId).orElseGet(Course::new);
    }

    @Override
    public String getCourseName(Course course) {
        return course.getName();
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public List<Course> getOnlyStartedCourses() {
        return courses;
    }

    @Override
    public List<Course> getOnlyNewCourses() {
        return courses;
    }

    @Override
    public void setCourse(Course course) {

    }

    @Override
    public void setCourse() {

    }

    @Override
    public List<Course> getAllInit() {
        return coursesToInit;
    }

    @Override
    public void removeCourse() {

    }
}
