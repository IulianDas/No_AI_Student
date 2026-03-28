package learnEnglish.repository;

import learnEnglish.entity.UserProgress;

import java.util.List;

public interface UserProgressRepository {

    List<UserProgress> getCourseProgressByUserId(int userId);
    void saveUserProgress(UserProgress userProgress);
    void updateUserProgress(UserProgress userProgress);
    int getLastId();

    UserProgress getCourseProgressByUserIdAndCourseId(int id, int courseId);
}
