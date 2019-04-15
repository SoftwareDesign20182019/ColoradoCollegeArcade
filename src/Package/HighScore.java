package Package;

import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Opens the high score screen
 * @author ellaneurohr
 *
 */
public class HighScore extends Application {


	private Stage primaryStage;
	private Arcade arcade;

	/**
	 * Loads the fxml and sets up the controller
	 * @param primaryStage - the new stage for this fxml file
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("HighScores.fxml"));
		Parent root = loader.load();
		HighScoreController controller = loader.<HighScoreController>getController();
		controller.initData(this);
		primaryStage.setTitle("High Score");
		primaryStage.setScene(new Scene(root, 600, 700));
		primaryStage.show();
	}

	/**
	 * Method that is called from the arcade class to call the start method in this class
	 * @param stage - the new stage for the high score screen
	 * @param arcade - the instance of the arcade, necessary for passing information from the arcade to the controller
	 * @throws Exception
	 */
	public void displayHighScores(Stage stage, Arcade arcade) throws Exception{
		this.arcade = arcade;
		start(stage);
	}

	/**
	 * Gets the high scores from the database via the arcade 
	 * @return HashMap<String, String> of the names and scores
	 */
	public HashMap<String, String> getHighScores(){
		return arcade.getHighScores();
	}

	/**
	 * Gets the display name for the game the high scores are being displayed for 
	 * @return String - the display game name
	 */
	public String getGameName(){
		return arcade.getGameName();
	}

	/**
	 * Closes the stage
	 */
	@Override
	public void stop(){
		primaryStage.close();
	}

	/**
	 * Calls the play again method if the user chooses to
	 * @throws Exception
	 */
	public void playAgain() throws Exception {
		arcade.playAgain();
	}


}
