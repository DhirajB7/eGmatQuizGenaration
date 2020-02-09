package dataPackage;

import operations.QuizGeneration;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class QuizsSet {

    private LinkedHashSet<ArrayList<Question>> quizData;


    private void setQuizData(int numberOfQuestionInQuiz) {
        this.quizData = new QuizGeneration().getQuizsSetFromQuizGeneration(numberOfQuestionInQuiz);
    }

    public LinkedHashSet<ArrayList<Question>> getQuizData(int numberOfQuestionInQuiz) {
        setQuizData(numberOfQuestionInQuiz);
        return quizData;
    }


}
