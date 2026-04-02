package learnEnglish.service.impl;

import learnEnglish.entity.Lesson;
import learnEnglish.entity.UserProgress;
import learnEnglish.repository.UserProgressRepository;
import learnEnglish.service.UserProgressService;


public class UserProgressServiceImpl implements UserProgressService {

    private final UserProgressRepository userProgressRepository;

    public UserProgressServiceImpl(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    @Override
    public void updateUserProgress (int userId, Lesson chosenLesson) {

        int index = userProgressRepository.getLastId() + 1;
        if (chosenLesson.getLessonOrder() == 1) {
            UserProgress userProgress = new UserProgress(index, userId, chosenLesson.getCourseId(),1);
            userProgressRepository.saveUserProgress(userProgress);
        } else {
            UserProgress userProgress = userProgressRepository.getCourseProgressByUserIdAndCourseId(userId,chosenLesson.getCourseId());
            userProgress.setProgressLessonCounter(userProgress.getProgressLessonCounter() + 1);
            userProgressRepository.updateUserProgress(userProgress);
        }

    }
}
