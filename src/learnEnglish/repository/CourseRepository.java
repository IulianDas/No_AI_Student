package learnEnglish.repository;

import learnEnglish.entity.Course;

import java.util.List;

public interface CourseRepository {
    Course getCourse();
    String getCourseName(Course course);
    List<Course> getAllCourses();
    List<Course> getOnlyStartedCourses();
    List<Course> getOnlyNewCourses();
    void setCourse(Course course);
    void removeCourse();
    void setCourse();
}
