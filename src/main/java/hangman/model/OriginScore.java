package hangman.model;

public abstract class OriginScore implements GameScore{

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        return 0;
    }
}
