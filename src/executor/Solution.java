package executor;

import dataPackage.Question;
import dataPackage.QuizsSet;
import operations.QuizGeneration;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Solution {

    public static void main(String[] args) {
        LinkedHashSet<ArrayList<Question>> answer = new QuizsSet().getQuizData(10);
        System.out.println("Valid Quiz Number : "+answer.size()+"\n"+"They Are : "+"\n");
        answer.forEach(a->{
            a.forEach(b-> System.out.println(b.getQuestionNumber()+"|"+b.getDifficultyLevel()+"|"+b.getTagNumber()));
            System.out.println("\n");
        });

    }

}

