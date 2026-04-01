package learnEnglish.repository.impl;

import learnEnglish.entity.Question;
import learnEnglish.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionRepositoryImpl implements QuestionRepository {

    private static final List<Question> questions = new ArrayList<>();

    public QuestionRepositoryImpl() {
        questions.add(new Question(41001, "Who are you?",2, new String[]{"0) I am a Jira","1) I am a Ramen","2) I am a Human","3) I am USA Navy"}, 1));
        questions.add(new Question(41002, "Who are me?",1, new String[]{"0) I am a Calculator","1) I am a Machine","2) I am a Human","3) I am Moldova"}, 2));
        questions.add(new Question(42001, "What doing a man when he have a trouble?",2, new String[]{"0) Dancing in a moon light","1) Buy ticket to space","2) Think obout solution","3) Play with the indians"}, 3));
        questions.add(new Question(42002, "What doing a women when she goes?",0, new String[]{"0) Dancing in a moon light(is right)","1) Cry tonight","2) Think obout solution","3) Play with the indians"}, 4));
    }

    @Override
    public void createQuestion(int quizId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce the question: \n");
        String question = scanner.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        String[] responseVariants = new String[4];
        for (int i = 0; i <= 3; i++){
            System.out.println("\n\t [" + i +"] ");
            responseVariants[i] = " "+i+")" + scanner.nextLine();
        }
        System.out.println("\n Introduce number id of correct answer: \n");
        int answer = scanner.nextInt();
        int questionNewId = questions.getLast().getId()+1;
        questions.add( new Question(questionNewId,question, answer, responseVariants, quizId));
    }

    @Override
    public List<Question> getAllQuestion() {
        return questions;
    }

    @Override
    public List<Question> getAllQuestionByQuizId(int id) {
        return questions.stream().filter(question -> question.getQuizId() == id).toList();
    }

    @Override
    public void removeQuestion(int quizId) {
        questions.removeIf(question -> question.getQuizId() == quizId);
        System.out.println("\n Questions are deleted!");
    }

    @Override
    public void updateQuestion(int id) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Introduce the new question: \n");
        String newQuestion = scanner.nextLine();
        System.out.println("\n Introduce 4 variants of response and 1 of them should be true: \n");
        String[] responseVariants = new String[4];
        for (int i = 0; i <= 3; i++){
            System.out.println("\n\t [" + i +"] ");
            responseVariants[i] = " "+i+")" + scanner.nextLine();
        }
        System.out.println("\n Introduce number id of correct answer: \n");
        int answer = scanner.nextInt();
        int questionId = questions.stream().filter(question -> question.getQuizId() == id).findFirst().get().getId();
        int indexOfQuestion = questions.indexOf(questions
                .stream()
                .filter(question ->  question.getQuizId() == id)
                .findFirst().get());
        questions.set(indexOfQuestion, (new Question(questionId, newQuestion, answer, responseVariants, id)));
        System.out.println("\n Question is updated!");
    }
}
