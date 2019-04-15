package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Opens the Javelin Throw screen
 * @author ellaneurohr
 *
 */
public class JavelinThrow extends Application implements Game {

	private Stage primaryStage;
	private int score;
	private Arcade arcade;
	boolean isGameDone;

	/**
	 * Loads the fxml and sets up the controller
	 * @param primaryStage - the new stage for this fxml file
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		isGameDone = false;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Javelin.fxml"));
		Parent root = loader.load();
		JavelinController controller = loader.<JavelinController>getController();
		controller.initData(this);
		primaryStage.setTitle("Javelin Throw!");
		primaryStage.setScene(new Scene(root, 790,400));
		primaryStage.show();
	}

	/**
	 * Calls the start method
	 * Gets called from the main arcade class
	 * @param stage - the new stage for this game
	 * @param arcade - the instance of the arcade
	 * @return int - the score
	 * @throws Exception
	 */
	public int playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
		return score;
	}

	/**
	 * Sets the score of the game
	 * @param score - the game score
	 */
	@Override
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * The database name of the game
	 * @return String - game name
	 */
	@Override
	public String toString() {
		return "javelinThrow";
	}

	/**
	 * The display name of the game
	 * @return String - game name
	 */
	@Override
	public String getGameName() {
		return "Javelin Throw";
	}

	/**
	 * calls the arcade method to end the game and prompt name selection
	 * @throws Exception
	 */
	@Override
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		primaryStage.close();
	}
}
