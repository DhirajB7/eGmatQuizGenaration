package com.eGmat.driver;

import com.eGmat.ObjectModel.Question;
import com.eGmat.ObjectModel.QuizsSet;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Solution {

    /**
     * Main method
     * getQuizData has parameter as 10(Number of questions in one quiz)
     * pass parameter as other number if number of questions in quiz has to change
     * @param args
     */
    public static void main(String[] args) {
        LinkedHashSet<ArrayList<Question>> answer = new QuizsSet().getQuizData(10);
        System.out.println("Valid Quiz Number : "+answer.size()+"\n"+"They Are : "+"\n");
        answer.forEach(a->{
            a.forEach(b-> System.out.println(b.getQuestionNumber()+"|"+b.getDifficultyLevel()+"|"+b.getTagNumber()));
            System.out.println("\n");
        });

    }

}

