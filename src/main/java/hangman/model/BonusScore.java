package hangman.model;

public abstract class BonusScore implements GameScore {

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
}
