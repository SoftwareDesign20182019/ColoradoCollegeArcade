package Package;
import java.util.Random;
import javafx.stage.Stage;

/**
 * Game implementation that randomly returns high score to the player
 *
 */
public class RandomScore implements Game {

	/**
	 * runs the game
	 * @return the high score for the game
	 */
    public int playGame(Stage stage, Arcade arcade) throws Exception{
        return scoreGame();
    }
    
    /**
     * gives a random high score for the game
     * @return the randomly calculated integer
     */
    private int scoreGame(){
        return (int) (Math.random() * 100000);
    }
    
    /**
     */
    public String getGameName() {
    	return "Random Game";
    }
    
    /**
     * gives the string representation of the game
     * @return the string representation
     */
    public String toString() {
    	return "RandomScore";
    }
    
    public boolean isGameDone() {
    	return true;
    }
    
    public void setGameToDone() {
    }

}
