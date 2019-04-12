package Package;
import java.util.Random;

/**
 * Game implementation that randomly returns high score to the player
 *
 */
public class RandomScore implements Game {

	/**
	 * gets the high score
	 * @return the high score for the game
	 */
    public int getScore(){
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
     * currently gives the player a random 3-letter name
     * @return the 3 letter name string
     */
    public String getName() {
    	Random r = new Random();
    	String name = "";
    	for (int i = 0; i < 3; i++) {
    		char letterInName = (char)(r.nextInt(26) + 'a');
    		name = name + letterInName;
    	}
    	return name;
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
    
    public void setGameDone() {}
}
