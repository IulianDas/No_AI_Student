package learnEnglish.repository.impl;

import learnEnglish.entity.Course;
import learnEnglish.entity.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements learnEnglish.repository.CourseRepository {

    private static List<Lesson> lesson = new LessonRepository().getLessons();
    private static List<Course> courses = new ArrayList<>();
    private static Course course = new Course(01,"Who are you lesson", (List<Lesson>) lesson);

    public CourseRepository() {
    }

    @Override
    public Course getCourse() {
        return course;
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
    public void removeCourse() {

    }
}
