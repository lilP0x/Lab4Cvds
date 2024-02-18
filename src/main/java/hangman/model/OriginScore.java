package hangman.model;

public  class OriginScore implements GameScore{
    private int score = 100;
    @Override
    public int calculateScore(int correctCount, int incorrectCount)throws ModelException  {
        //Inicia con una puntuacion de 100
        if (correctCount < 0 || incorrectCount < 0) {
            throw new ModelException("Parámetros incorrectos: correctCount e incorrectCount deben ser no negativos.");
        }

        if(incorrectCount != 0 && score != 0){
            score = score - incorrectCount*10;
            if(score < 0){
                score = 0;
            }
        }

        return score;
    }

    @Override
    public void restart() {
        score = 100;
    }

}
