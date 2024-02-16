package hangman.model;

public  class OriginScore implements GameScore{
    private int score = 100;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        //Inicia con una puntuacion de 100

        if(incorrectCount != 0 && score != 0){
            score = score - incorrectCount*10;
            if(score < 0){
                return 0;
            }
        }

        return score;
    }

    @Override
    public void restart() {
        score = 100;
    }

}
