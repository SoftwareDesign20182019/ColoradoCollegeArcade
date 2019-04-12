package Package;

/**
 * interface for the various arcade games
 *
 */
public interface Game {
	
	/**
	 * gets the high score
	 * @return the score of the game
	 */
	int getScore();
	
	/**
	 * prompts the user to enter their name via a new javaFX window
	 * @return the user's name
	 */
	String getName();
	
	/**
	 * the string representation of the game
	 * @return the string
	 */
	String toString();
	
	boolean isGameDone();
	
	void setGameDone();
	
}
