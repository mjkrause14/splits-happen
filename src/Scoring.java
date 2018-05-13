
public class Scoring {

    //Final variable that holds the strike symbol
    private final char STRIKE =  'X';

    //Final variable that holds the spare symbol
    private final char SPARE = '/';

    //Final variable that holds the miss symbol
    private final char MISS = '-';


    //Define the character array that will hold the line
    private char[] scoreVal;


    //Constructor
    public Scoring(char[] scoreVal) {
        this.scoreVal = scoreVal;
    }

    //Declare the total score
    private int score = 0;

    //Add the roll score to the running score
    private void add(int rollScore) {
        score += rollScore;
    }

    //return the score to BowlingScore
    public int getScore() {
        return score;
    }

    //Check to see if the score is in the last 4 rolls
    public void getScoreVal(char roll, int index) {
        if(index > scoreVal.length - 4) {
            getExtraScore(index);
        }
        else {
            getLineScore(roll, index);
        }
    }

    //Calculate all rolls up to the last 3
    private void getLineScore(char roll, int index) {
        if(Character.isDigit(scoreVal[index])) {
            add(getNumVal(index));
        }
        else if(roll == STRIKE) {
            calcStrike(index);
        }
        else if(roll == SPARE) {
            calcSpare(index);
        }
        else if(roll == MISS) {
            add(0);
        }
    }

    //Calculate the last 3 rolls
    //Handled differently to make sure there is not an ArrayOutOfBounds error
    private void getExtraScore(int index) {
         if(index > scoreVal.length - 4) {
             if(scoreVal[index] == STRIKE) {
                 add(10);
             }
             else if(scoreVal[index] == SPARE) {
                 add(10 - (getNumVal(index + 1)));
             }
             else if(scoreVal[index] == MISS) {
                 add(0);
             }
             else {
                 add(getNumVal(index));
             }
         }
    }

    //Calculate the value of a strike
    private void calcStrike(int index) {
        add(10);

        //Loop through the next 2 rolls to calculate total strike score
        for(int i = index + 1; i < index + 3; i++) {
            if(scoreVal[i] == STRIKE) {
                add(10);
            }
            else if(scoreVal[i] == SPARE) {
                add(10 - getNumVal(i - 1));
            }
            else if(scoreVal[i] == MISS) {
                add(0);
            }
            else {
                add(getNumVal(i));
            }
        }
    }

    //Calculate the value of a spare
    private void calcSpare(int index) {
        //Check that to see if the next roll is a miss
        if(scoreVal[index + 1] == MISS) {
            add(10 - getNumVal(index - 1));
        }
        //If not a miss calculate the spare score normally
        else {
            add(10 - getNumVal(index - 1) + getNumVal(index + 1));
        }
    }

    //Get the numeric value for characters in scoreVal
    private int getNumVal(int index) {
        return Character.getNumericValue(scoreVal[index]);
    }
}
