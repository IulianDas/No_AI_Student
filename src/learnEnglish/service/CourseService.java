package learnEnglish.service;

import learnEnglish.entity.Course;
import learnEnglish.entity.User;
import learnEnglish.repository.CourseRepository;

import java.util.List;

public interface CourseService {
    void startLesson(User user);
    void getAllCourses(CourseRepository courseRepository);
    void getUserProgress(User user);
    List<Integer> getCourseListByUsersId(User user);

    List<Course> getCoursesByListId(List<Integer> ids);

    void getStartedCourses(List<Course> courses);
}
