package dataPackage;

import operations.FillQuestions;

import java.util.LinkedHashSet;

public class QuestionBank {

    private LinkedHashSet<Question> questionSet;

    private void setQuestionSet() {
        this.questionSet = new FillQuestions().fillQuestionFromFile();
    }

    public LinkedHashSet<Question> getQuestionSet() {
        setQuestionSet();
        return questionSet;
    }
}
