package learnEnglish.service;

import learnEnglish.entity.Course;

import java.util.List;

public interface CourseService {
    void startLesson(int userId);
    void getAllCourses();
    void getUserProgress(int userId);
    List<Integer> getCourseListByUsersId(int userId);

    List<Course> getCoursesByListId(List<Integer> ids);

    void getStartedCourses(List<Course> courses);
}
