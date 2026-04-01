package learnEnglish.repository.impl;

import learnEnglish.entity.Quiz;
import learnEnglish.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

public class QuizRepositoryImpl implements QuizRepository {

    private static final List<Quiz> quizzes = new ArrayList<>();

    public QuizRepositoryImpl() {
        quizzes.add(new Quiz(1,1));
        quizzes.add(new Quiz(2,2));
        quizzes.add(new Quiz(3,3));
        quizzes.add(new Quiz(4,4));
    }

    @Override
    public int createQuiz(int lessonId) {
        int newQuizId = quizzes.getLast().getId()+1;
        quizzes.add(new Quiz( newQuizId, lessonId));
        return newQuizId;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizzes;
    }

    @Override
    public void removeQuiz(int lessonId) {
        quizzes.removeIf(quiz -> quiz.getLessonId() == lessonId);
        System.out.println("\n Quiz is Deleted!");
    }

    @Override
    public Quiz getQuizByLessonId(int lessonId) {
        return quizzes.stream().filter(quiz -> quiz.getLessonId() == lessonId).findAny().orElseGet(Quiz::new);
    }
}
