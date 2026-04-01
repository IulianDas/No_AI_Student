package learnEnglish.repository;

import learnEnglish.entity.Course;

import java.util.List;

public interface CourseRepository {
    Course getCourse(int courseId);
    List<Course> getAllCourses();
    int createNewCourse();
    void removeCourse(int courseId);
    List<Course> getAllInit();
    void updateCourseName(int courseId, String updatedCourseName);
    List<Course> getAllCoursesByListId(List<Integer> ids);
}
