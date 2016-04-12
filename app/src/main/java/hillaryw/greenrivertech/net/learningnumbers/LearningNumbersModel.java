package hillaryw.greenrivertech.net.learningnumbers;

import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Hillary on 4/12/2016.
 */
public class LearningNumbersModel {

    private int leftSide;
    private int rightSide;
    private int score;
    private int timesPlayed;
    public static final int Left = 0;
    public static final int Right = 1;

    public LearningNumbersModel(){
        timesPlayed =0;
        score = 0;
    };

    public boolean play(int choice) {

        timesPlayed++;

        if (choice == 0 && leftSide > rightSide) {

            score++;
            return true;
        }
        else if (choice == 1 && rightSide > leftSide){

            score++;
            return true;
        }
        else{
            return false;
        }

    }

    public int getLeftSide(){

        return leftSide;
    }
    public int getRightSide() {

        return rightSide;
    }

    public int getScore() {
        return score;
    }

    public int getTimesPlayed() {

        return timesPlayed;
    }



    public void generateNumber() {

        Random random = new Random();

        leftSide = random.nextInt(10)+1;
        rightSide = random.nextInt(10)+1;

        while(leftSide == rightSide) {

            rightSide = random.nextInt(10) + 1;

        }


    }

}
