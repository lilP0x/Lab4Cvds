package hangman.model;
import hangman.model.ModelException;

public interface GameScore {
    public int calculateScore(int correctCount, int incorrectCount) throws ModelException;
    void restart();
}
