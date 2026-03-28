package learnEnglish.repository.impl;

import learnEnglish.entity.UserProgress;
import learnEnglish.repository.UserProgressRepository;

import java.util.ArrayList;
import java.util.List;

public class UserProgressRepositoryImpl  implements UserProgressRepository {

    private final List<UserProgress> userProgressRepository = new ArrayList<>();


    @Override
    public List<UserProgress> getCourseProgressByUserId(int userId) {
        return userProgressRepository.stream().filter(userProgress -> userProgress.getUser().getId() == userId).toList();
    }

    @Override
    public void saveUserProgress(UserProgress userProgress) {
        userProgressRepository.add(userProgress);
    }

    @Override
    public void updateUserProgress(UserProgress updateProgress) {
        for (UserProgress userProgress: userProgressRepository){
            if (userProgress.getId() == updateProgress.getId()){
                int indexPosition = userProgressRepository.indexOf(userProgress);
                userProgressRepository.set(indexPosition,updateProgress);
            }
        }

    }
}
