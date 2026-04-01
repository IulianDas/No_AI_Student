package learnEnglish.repository.impl;

import learnEnglish.entity.Course;
import learnEnglish.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public int createNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce name of the new course: ");
        String courseName = scanner.nextLine();
        int newId = courses.getLast().getId()+1;
        courses.add(new Course(newId, courseName));
        return newId;
    }


    @Override
    public List<Course> getAllInit() {
        return courses;
    }

    @Override
    public void updateCourseName(int courseId, String updatedCourseName) {
        int indexPosition = courses.indexOf(courses.stream().filter(course -> course.getId() == courseId).findFirst().get());
        Course updatedCourse = courses.stream().filter(course -> course.getId() == courseId).findAny().get();
        updatedCourse.setName(updatedCourseName);
        courses.set(indexPosition, updatedCourse);
        System.out.println("\n Name is changed!");
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
