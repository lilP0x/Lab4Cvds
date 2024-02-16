package hangman.model;

public class BonusScore implements GameScore {
    private int score = 0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {

        if(correctCount != 0){
            score = score + correctCount*10;

        }

        if(incorrectCount != 0 && score != 0){
            score = score - incorrectCount*5;
            if(score < 0){
                score = 0;
            }
        }


        return score;
    }

    @Override
    public void restart() {
        score = 0;
    }
}
