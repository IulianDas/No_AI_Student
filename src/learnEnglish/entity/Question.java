package learnEnglish.entity;

public class Question {

    private  int id;
    private String question;
    private String answer;
    private String[] variant;
    private boolean checkIfPass;

    public Question(int id, String question, String answer, String[] variant, boolean checkIfPass) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.variant = variant;
        this.checkIfPass = checkIfPass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getVariant() {
        return variant;
    }

    public void setVariant(String[] variant) {
        this.variant = variant;
    }

    public boolean isCheckIfPass() {
        return checkIfPass;
    }

    public void setCheckIfPass(boolean checkIfPass) {
        this.checkIfPass = checkIfPass;
    }
}
