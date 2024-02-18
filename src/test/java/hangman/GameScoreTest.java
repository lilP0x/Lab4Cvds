package hangman;


import hangman.model.BonusScore;
import hangman.model.GameScore;
import hangman.model.OriginScore;
import hangman.model.PowerScore;
import hangman.model.ModelException;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import hangman.model.ModelException;

public class GameScoreTest {
    /*
    OriginalScore
    Las fronteras para la clase OriginalScore van de 0 a 100
    Letras correctas no hay bonificación
    Letras incorrectas -10

    BonusScore
    Las fronteras para la clase BonusScore inicia en 0
    Letras correctas +10
    Letras incorrectas -5

    PowerScore
    Las fronteras para la clase BonusScore inicia en 0
    Letras correctas 5**i
    Letras incorrectas -8
    El puntaje maximo llega hasta 500
     */

    @Test
    public void originalScoreShouldReturnPerfectScore() throws ModelException {
        GameScore gameScore = new OriginScore();

        //Call method
        int result = gameScore.calculateScore(5,0);
        int result1 = gameScore.calculateScore(1,1);
        int result2 = gameScore.calculateScore(4,11);

        //Asserts
        Assert.assertEquals(100,result);
        Assert.assertEquals(90,result1);
        Assert.assertEquals(0,result2);
    }

    @Test
    public void originalScoreShouldNotReturnPerfectScore() throws ModelException {

        GameScore gameScore = new OriginScore();

        //Call method
        int result = gameScore.calculateScore(5,10);
        //Assert

        Assert.assertEquals(0,result);
        //implemente este metodo en la interfaz porque note que las pruebas estaban teneniendo problemas ya que
        // tomaban el mismo score
        gameScore.restart();
        //Call method

        int result1 = gameScore.calculateScore(0,5);
        Assert.assertEquals(50,result1);

    }
    
    @Test
    public void bonusScoreShouldInitializeGameInZero() throws ModelException{

        GameScore gameScore = new BonusScore() ;
        //Call method
        int result = gameScore.calculateScore(0,0);
        int result1 = gameScore.calculateScore(1,1);
        //Asserts
        Assert.assertEquals(0,result);
        Assert.assertEquals(5,result1);
    }
    
    @Test
    public void bonusScoreShouldNotDecreaseScore() throws ModelException{
        GameScore gameScore = new BonusScore();
        //Call method
        int result = gameScore.calculateScore(0,3);
        //Asserts
        Assert.assertEquals(0,result);
    }

    
    @Test
    public void powerScoreShould() throws ModelException{
        GameScore gameScore = new PowerScore();
        //Call method
        int result = gameScore.calculateScore(0,3);
        int result1 = gameScore.calculateScore(3,0);

        //Asserts
        Assert.assertEquals(0,result);
        Assert.assertEquals(125,result1);

    }
    
    @Test
    public void powerScoreShouldNotOvercome500()throws ModelException{
        GameScore gameScore = new PowerScore();
        //Call method
        int result = gameScore.calculateScore(4,1);
        int result1 = gameScore.calculateScore(1,1);

        //Asserts
        Assert.assertEquals(500,result);
        Assert.assertEquals(0,result1);

    }
    
}
