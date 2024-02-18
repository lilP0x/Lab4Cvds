package hangman.model;
import hangman.model.ModelException;

public class BonusScore implements GameScore {
    private int score = 0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount)throws ModelException {
        if (correctCount < 0 || incorrectCount < 0) {
            throw new ModelException("Parámetros incorrectos: correctCount e incorrectCount deben ser no negativos.");
        }

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
