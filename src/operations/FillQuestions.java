package operations;

import dataPackage.Question;
import dataPackage.QuestionBank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FillQuestions {

    String filePath = "resource/data.txt";
    LinkedHashSet<Question> questionSet;

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
