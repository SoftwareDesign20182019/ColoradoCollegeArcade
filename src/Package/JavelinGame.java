package Package;
import java.util.Random;

public class JavelinGame implements Game {

	private int gameScore;
	private boolean gameDone;
	
	public JavelinGame () {
		gameDone = false;
	}
		
	/**
	 * gets the high score
	 * @return the high score for the game
	 */
	public int getScore() {
		return gameScore;
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
    	return "JavelinThrow";
    }
    
    /**
     * sets the high score
     * @param the integer score to set
     */
    public void setScore(int score) {
    	gameScore = score;
    }
    
    public void setGameDone() {
    	gameDone = true;
    }
    
    public boolean isGameDone() {
    	return gameDone;
    }


	
}
