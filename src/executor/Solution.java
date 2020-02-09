package executor;

import dataPackage.QuestionBank;
import operations.FillQuestions;

public class Solution {

    public static void main(String[] args) {

        QuestionBank qb = new QuestionBank();
        qb.getQuestionSet().forEach(a->{
            System.out.print(a.getQuestionNumber()+"|");
            System.out.print(a.getDifficultyLevel()+"|");
            System.out.print(a.getTagNumber());
            System.out.println("");
        });

    }

}

