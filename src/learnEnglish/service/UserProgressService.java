package learnEnglish.service;

import learnEnglish.entity.Lesson;

public interface UserProgressService {

    void updateUserProgress (int userId, Lesson chosenLesson);

}
