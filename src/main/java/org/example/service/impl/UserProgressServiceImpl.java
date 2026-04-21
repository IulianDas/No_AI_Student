package org.example.service.impl;

import org.example.entity.UserProgress;
import org.example.repository.UserProgressRepository;
import org.example.service.UserProgressService;

import java.sql.SQLException;


public class UserProgressServiceImpl implements UserProgressService {

    private final UserProgressRepository userProgressRepository;

    public UserProgressServiceImpl(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    @Override
    public void updateUserProgress (UserProgress userProgress) throws SQLException {

        UserProgress userProgressCheck = userProgressRepository.getCourseProgressByUserIdAndCourseId(userProgress.getUserId(), userProgress.getCourseId());
        if (userProgressCheck == null) {
            userProgressRepository.saveUserProgress(userProgress);
        } else {
            userProgress.setProgressLessonCounter(userProgressCheck.getProgressLessonCounter()+userProgress.getProgressLessonCounter());
            userProgressRepository.updateUserProgress(userProgress);
        }

    }
}
