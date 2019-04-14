package Package;
import javafx.stage.Stage;

/**
 * interface for the various arcade games
 *
 */
public interface Game {
	
	/**
	 * runs the game
	 * @return the score of the game
	 */
	int playGame(Stage stage, Arcade arcade) throws Exception;
	
	/**
	 *
	 * @return
	 */
	String getGameName();
	
	/**
	 * the string representation of the game
	 * @return the string
	 */
	String toString();

	boolean isGameDone();

	void setGameToDone() throws Exception;

	
}
