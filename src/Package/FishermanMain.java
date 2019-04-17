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
	
	@Override
	/**
	 * creates the controller and data is fed in
	 * @param fishermanStage the stage to use to set up the javaFX
	 * @throws Exception for JavaFX related issues
	 */
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

	@Override
	/**
	 * passes in a stage and arcade, then starts the stage
	 * @param stage the stage to set up
	 * @param arcade the arcade to contact
	 * @throws Exception for javaFX related issues
	 */
	public void playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
	}

	@Override
	/**
	 * simple name for database
	 * @return the string for the database name
	 */
	public String getGameName() {
		return "Fisherman";
	}

	@Override
	/**
	 * feeds score back to arcade and closes the game window
	 * @throws Exception for JavaFX related issues
	 */
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		fishermanStage.close();
	}

	@Override
	/**
	 * sets the score of the game in the view
	 * @param score the score to set to
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	/**
	 * toString for the game name
	 * @return the game name
	 */
	public String toString() {
		return "Fisherman";
	}
}
