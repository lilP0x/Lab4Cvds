package hangman.model;

public class PowerScore implements GameScore {
    private int score = 0;
    private final int MAX_SCORE = 500;

    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        score = 0;
        if (correctCount > 0) {
            score = (int) Math.pow(5, correctCount);
        }
        score -= incorrectCount * 8;
        if (score < 0) {
            score = 0;
        }
        if (score > MAX_SCORE) {
            score = MAX_SCORE;
        }
        return score;
    }

    @Override
    public void restart() {
        score = 0;
    }
}
