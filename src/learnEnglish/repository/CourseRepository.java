package learnEnglish.repository;

import learnEnglish.entity.Course;

import java.util.List;

public interface CourseRepository {
    Course getCourse(int courseId);
    List<Course> getAllCourses();
    void createNewCourse(Course newCourse);
    void removeCourse(int courseId);
    List<Course> getAllInit();
    void updateCourseName(int indexPosition, Course updatedCourseName);
    List<Course> getAllCoursesByListId(List<Integer> ids);
}
