package operations;

import dataPackage.Question;
import dataPackage.QuestionBank;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class QuizGeneration {

    private ArrayList<Question> allQuestions;

    private LinkedHashSet<ArrayList<Question>> finalQuizList;

    private void getAllQuestions(){
        this.allQuestions = (ArrayList<Question>) new QuestionBank().getQuestionSet().stream().collect(Collectors.toList());
    }

    private boolean checkTag(){
        return true;
    }


   private boolean checkLevel(){
        return true;
   }

   public LinkedHashSet<ArrayList<Question>> getQuizsSetFromQuizGeneration(int numberOfQuestionInQuiz){
       getAllQuestions();
       ArrayList<Question> arrayListquestion = new ArrayList<>();
       for(int i = 0 ; i < allQuestions.size() ;i=i+numberOfQuestionInQuiz){
           for(int j = 0 ; j < numberOfQuestionInQuiz;j++){
               arrayListquestion.add(allQuestions.get(i));
           }
           if(checkTag()&&checkLevel()){
               finalQuizList.add(arrayListquestion);
           }
           arrayListquestion.clear();
       }
       return finalQuizList;
   }



}
