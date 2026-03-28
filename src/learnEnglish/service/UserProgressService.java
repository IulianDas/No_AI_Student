package learnEnglish.service;

import learnEnglish.entity.Lesson;
import learnEnglish.entity.User;

public interface UserProgressService {

    void updateUserProgress (User user, Lesson chosenLesson);

}
