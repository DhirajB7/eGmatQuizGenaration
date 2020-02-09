package com.eGmat.ObjectModel;

import com.eGmat.logic.FillQuestions;

import java.util.LinkedHashSet;

public class QuestionBank {

    private LinkedHashSet<Question> questionSet;

    /**
     * Get question objects
     * from external File--->FillQuestions--->THIS SET OF Question Objects
     */
    private void setQuestionSet() {
        this.questionSet = new FillQuestions().fillQuestionFromFile();
    }

    /**
     * Call setQuestionSet private method first
     * Return QuestionSet to File QuizGeneration.Java
     * @return
     */
    public LinkedHashSet<Question> getQuestionSet() {
        setQuestionSet();
        return questionSet;
    }
}
