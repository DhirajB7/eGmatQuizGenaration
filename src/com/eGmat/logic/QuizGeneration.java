package com.eGmat.logic;

import com.eGmat.ObjectModel.Question;
import com.eGmat.ObjectModel.QuestionBank;
import com.eGmat.constants.Levels;
import com.eGmat.constants.Tags;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class QuizGeneration {

    private ArrayList<Question> allQuestions;

    private LinkedHashSet<ArrayList<Question>> finalQuizList = new LinkedHashSet<>();

    /**
     * all question objects are in form of set is being converted to ArrayList for easy operation
     */
    private void getAllQuestions(){
        this.allQuestions = (ArrayList<Question>) new QuestionBank().getQuestionSet().stream().collect(Collectors.toList());
    }

    /**
     * Check if all question have Tag1 to Tag 6
     * @param arrayListQuestions
     * @return true is go for next check else reject that arraylist of question
     */
    private boolean checkTag(ArrayList<Question> arrayListQuestions){
        boolean flag = true;

       ArrayList<String> arrayListOfStrings = (ArrayList) arrayListQuestions.stream().map(a->a.getTagNumber()).collect(Collectors.toList());

        for(Tags tag : Tags.values()){

         if(arrayListOfStrings.contains(tag.toString())){
             flag=flag&&true;
         }else{
             flag=flag&&false;
             break;
         }

        }

        return flag;
    }

    /**
     * check if atleast 2 EASY,MEDIUM,HARD ARE THERE
     * @param arrayListQuestions
     * @return if true add questionList to Set of Final Datastructure
     * else reject the question array list
     */
   private boolean checkLevel(ArrayList<Question> arrayListQuestions){
       boolean flag = true;

       ArrayList<String> arrayListOfLevel = (ArrayList) arrayListQuestions.stream().map(a->a.getDifficultyLevel()).collect(Collectors.toList());

       for(Levels level : Levels.values()){

           if(arrayListOfLevel.stream().filter(a->a.equalsIgnoreCase(level.toString())).count()>=2){
               flag=flag&&true;
           }else{
               flag=flag&&false;
               break;
           }

       }

       return flag;
   }

    /**
     * ArrayList according to number of question per quiz Condition.
     * @param numberOfQuestionInQuiz
     * @return LinkedHashSet<ArrayList<Question>> passed to main
     */
   public LinkedHashSet<ArrayList<Question>> getQuizsSetFromQuizGeneration(int numberOfQuestionInQuiz){
       getAllQuestions();
       for(int i = 0 ; i < allQuestions.size() ;i=i+numberOfQuestionInQuiz){
           ArrayList<Question> arrayListquestion = new ArrayList<>();
           for(int j = i ; j < i+numberOfQuestionInQuiz;j++){
               arrayListquestion.add(allQuestions.get(j));
           }
           if(checkTag(arrayListquestion)&&checkLevel(arrayListquestion)){
               finalQuizList.add(arrayListquestion);
           }
       }
       return finalQuizList;
   }

}
