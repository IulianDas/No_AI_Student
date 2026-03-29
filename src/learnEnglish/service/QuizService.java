package learnEnglish.service;

import learnEnglish.entity.Lesson;
import learnEnglish.entity.User;

public interface QuizService {

    void startQuiz(Lesson lessonQuiz, User user);
}
