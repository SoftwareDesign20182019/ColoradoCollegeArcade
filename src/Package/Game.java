package Package;
import javafx.stage.Stage;

/**
 * Interface for the various arcade games
 *
 */
public interface Game {

	/**
	 * Runs the game
	 * Calls the start method for the stage
	 * @param stage - the new stage for the game
	 * @param arcade - the instance of the arcade, necessary for retrieving arcade data
	 * @return int - the score of the game
	 * @throws Exception
	 */
	int playGame(Stage stage, Arcade arcade) throws Exception;

	/**
	 * Returns the name of the game for display purposes
	 * @return String - the displayed game name
	 */
	String getGameName();

	/**
	 * Returns the string representation of the game for database purposes
	 * @return String - the database game name
	 */
	String toString();

	/**
	 * calls the arcade method to end the game and prompt name selection
	 * @throws Exception
	 */
	void setGameToDone() throws Exception;
	
	/**
	 * Sets the score at the end of the game
	 * @param score - game score
	 */
	void setScore(int score);
	
}
