package learnEnglish.repository.impl;

import learnEnglish.entity.Course;
import learnEnglish.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private static final List<Course> courses = new ArrayList<>();

    public CourseRepositoryImpl() {
        courses.add(new Course(1,"Who are someone in English"));
        courses.add(new Course(2,"How to use times in English"));
    }

    @Override
    public Course getCourse(int courseId) {
        return courses.stream().filter(course -> course.getId() == courseId).findAny().orElseGet(Course::new);
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public void createNewCourse(Course newCourse){
        courses.add(newCourse);
    }


    @Override
    public List<Course> getAllInit() {
        return courses;
    }

    @Override
    public void updateCourseName(int indexPosition, Course updatedCourse) {
        courses.set(indexPosition, updatedCourse);
    }

    @Override
    public List<Course> getAllCoursesByListId(List<Integer> ids) {
        return courses.stream().filter(course -> ids.contains(course.getId())).toList();
    }

    @Override
    public void removeCourse(int courseId) {
        courses.removeIf(course -> course.getId() == courseId);
        System.out.println("\n Course ["+ courseId + "] is deleted!");
    }
}
