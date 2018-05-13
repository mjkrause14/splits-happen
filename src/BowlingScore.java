
public class BowlingScore {

    public static void main(String args[]) {
        //Line score to be used
        String line = "X7/9-X-88/-6XXX81";

        //Convert line to a character array
        char[] score = line.toCharArray();

        //Define the scoring system
        Scoring lineScore = new Scoring(score);

        //Loop through score character array
        for(int i = 0; i < score.length; i++) {
            lineScore.getScoreVal(score[i], i);
        }

        //Print the final score
        System.out.println(lineScore.getScore());
    }
}
