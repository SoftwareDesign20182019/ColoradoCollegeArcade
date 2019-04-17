package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Implementation of the game interface for the fisherman game
 * @author ellaneurohr
 *
 */
public class FishermanMain extends Application implements Game {

	private Stage fishermanStage;
	private Arcade arcade;
	private int score;
	
	/**
	 * Loads the fxml and sets up the controller
	 * @param primaryStage - the new stage for this fxml file
	 */
	@Override
	public void start(Stage fishermanStage) throws Exception {
		this.fishermanStage = fishermanStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Fisherman.fxml"));
		Parent root = loader.load();
		FishermanController controller = loader.<FishermanController>getController();
		controller.initData(this);
		fishermanStage.setTitle("Fisherman!");
		fishermanStage.setScene(new Scene(root, 600,600));
		fishermanStage.show();
	}

	/**
	 * Calls the start method
	 * Gets called from the main arcade class
	 * @param stage - the new stage for this game
	 * @param arcade - the instance of the arcade
	 * @throws Exception
	 */
	@Override
	public void playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
	}

	/**
	 * The display name of the game
	 * @return String - game name
	 */
	@Override
	public String getGameName() {
		return "Fisherman";
	}

	/**
	 * calls the arcade method to end the game and prompt name selection
	 * @throws Exception
	 */
	@Override
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		fishermanStage.close();
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
		return "Fisherman";
	}
}
