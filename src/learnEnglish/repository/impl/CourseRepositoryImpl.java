package learnEnglish.repository.impl;

import learnEnglish.entity.Course;
import learnEnglish.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private static final List<Course> courses = new ArrayList<>();

    public CourseRepositoryImpl() {
        courses.add(new Course(1,"Who are someone in English"));
        courses.add(new Course(2,"How to use a, an and is in English"));
    }

    @Override
    public Course getCourse(int courseId) {
        return courses.stream().filter(course -> course.getId() == courseId).findAny().orElseGet(Course::new);
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
        return courses;
    }

    @Override
    public List<Course> getAllCoursesByListId(List<Integer> ids) {
        return courses.stream().filter(course -> ids.contains(course.getId())).toList();
    }

    @Override
    public void removeCourse() {

    }
}
