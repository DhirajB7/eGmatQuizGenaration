package dataPackage;

public class Question {

    private String questionNumber;
    private String difficultyLevel;
    private String tagNumber;

    public String getQuestionNumber() {
        return questionNumber;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public Question(String questionNumber, String difficultyLevel, String tagNumber) {
        this.questionNumber = questionNumber;
        this.difficultyLevel = difficultyLevel;
        this.tagNumber = tagNumber;
    }

}
