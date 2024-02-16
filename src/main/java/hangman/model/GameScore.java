package hangman.model;

public interface GameScore {

    int calculateScore(int correctCount, int incorrectCount);

    //Este metodo reinicia el marcador
    void restart();
}
