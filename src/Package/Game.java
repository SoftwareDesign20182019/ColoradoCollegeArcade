package Package;

/**
 * interface for the various arcade games
 *
 */
public interface Game {
	
	/**
	 * runs the game
	 * @return the score of the game
	 */
	int playGame();
	
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
	
}
