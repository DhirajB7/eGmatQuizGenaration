package operations;

import dataPackage.Question;
import dataPackage.QuestionBank;
import variables.Levels;
import variables.Tags;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class QuizGeneration {

    private ArrayList<Question> allQuestions;

    private LinkedHashSet<ArrayList<Question>> finalQuizList;

    private void getAllQuestions(){
        this.allQuestions = (ArrayList<Question>) new QuestionBank().getQuestionSet().stream().collect(Collectors.toList());
    }

    private boolean checkTag(ArrayList<Question> arrayListQuestions){
        boolean flag = true;

       ArrayList<String> arrayListOfStrings = (ArrayList) arrayListQuestions.stream().map(a->a.getTagNumber()).collect(Collectors.toList());

        for(Tags tag : Tags.values()){

         if(arrayListOfStrings.contains(tag)){
             flag=flag&&true;
         }else{
             flag=flag&&false;
         }

        }

        return flag;
    }


   private boolean checkLevel(ArrayList<Question> arrayListQuestions){
       boolean flag = true;

       ArrayList<String> arrayListOfLevel = (ArrayList) arrayListQuestions.stream().map(a->a.getDifficultyLevel()).collect(Collectors.toList());

       for(Levels level : Levels.values()){

           if(arrayListOfLevel.stream().filter(a->a.equalsIgnoreCase(level.toString())).count()>=2){
               flag=flag&&true;
           }else{
               flag=flag&&false;
           }

       }

       return flag;
   }

   public LinkedHashSet<ArrayList<Question>> getQuizsSetFromQuizGeneration(int numberOfQuestionInQuiz){
       getAllQuestions();
       ArrayList<Question> arrayListquestion = new ArrayList<>();
       for(int i = 0 ; i < allQuestions.size() ;i=i+numberOfQuestionInQuiz){
           for(int j = 0 ; j < numberOfQuestionInQuiz;j++){
               arrayListquestion.add(allQuestions.get(i));
           }
           if(checkTag(arrayListquestion)&&checkLevel(arrayListquestion)){
               finalQuizList.add(arrayListquestion);
           }
           arrayListquestion.clear();
       }
       return finalQuizList;
   }



}