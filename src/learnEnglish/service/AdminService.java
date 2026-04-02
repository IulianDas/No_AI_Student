package learnEnglish.service;

public interface AdminService {
    void updateSelectedCourse();

    void createCourse();

    void deleteCourseById(int courseId);

    void getAllCourses();

}
