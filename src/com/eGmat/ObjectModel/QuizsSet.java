package com.eGmat.ObjectModel;

import com.eGmat.logic.QuizGeneration;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class QuizsSet {

    private LinkedHashSet<ArrayList<Question>> quizData;

    /**
     * Get Quiz(s) Set which has ArrayList of Quiz
     */
    private void setQuizData(int numberOfQuestionInQuiz) {
        this.quizData = new QuizGeneration().getQuizsSetFromQuizGeneration(numberOfQuestionInQuiz);
    }

    /**
     * Passed to main method
     * @param numberOfQuestionInQuiz
     * @return LinkedHashSet<ArrayList<Question>> for main()
     * for further operation
     */
    public LinkedHashSet<ArrayList<Question>> getQuizData(int numberOfQuestionInQuiz) {
        setQuizData(numberOfQuestionInQuiz);
        return quizData;
    }


}
