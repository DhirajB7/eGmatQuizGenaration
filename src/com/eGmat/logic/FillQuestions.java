package com.eGmat.logic;

import com.eGmat.ObjectModel.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FillQuestions {

    String filePath = "resource/data.txt";
    LinkedHashSet<Question> questionSet;

    /**
     * input : External data file
     * string in format "Q123|EASY|Tag1" is converted to Question object
     * LinkedHashSet is used to store question,because
     * 1) remove duplicate
     * 2) to preserve insertion order
     *
     * @return LinkedHashSet
     */
    public LinkedHashSet<Question> fillQuestionFromFile(){
        try {
            questionSet= new LinkedHashSet<>();
            Scanner scan = new Scanner(new File(filePath));
            while(scan.hasNextLine()){
                String[] data = scan.nextLine().split("\\|");
                questionSet.add(new Question(data[0],data[1],data[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            return questionSet;
        }

    }


}
