package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Class for the software tycoon game, sets the stage and returns the score and name
 * @author dhardwick
 *
 */
public class SoftwareTycoon extends Application implements Game {

	private Stage primaryStage;
	private int score;
	private Arcade arcade;
	boolean isGameDone;

	
	/**
	 * Starts the stage, calling the controller and FXML
	 * @param primaryStage the stage we see on screen
	 * @throws Exception if root is null
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		isGameDone = false;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Software.fxml"));
		Parent root = loader.load();
		SoftwareTycoonController controller = loader.<SoftwareTycoonController>getController();
		controller.initData(this);
		primaryStage.setTitle("Software Tycoon");
		primaryStage.setScene(new Scene(root, 600,700));
		primaryStage.show();
	}

	/**
	 * Instantiates arcade and gets the score
	 */
	public int playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
		return score;
	}

	/**
	 * Sets the score
	 * @param score the score the player earned
	 */
	public void setScore(int score) {
		System.out.println("Score is: " + score);
		this.score = score;
	}

	/**
	 * Gets the name of the player
	 * @return the name
	 */
	public String toString() {
		return "SoftwareTycoon";
	}

	/**
	 * Returns the game's state
	 * @return true if the game is done
	 */
	public boolean isGameDone() {
		return isGameDone;
	}

	/**
	 * Sets game to done 
	 */
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		primaryStage.close();
	}

	/**
	 * Returns the name of the game as a string
	 */
	@Override
	public String getGameName() {
		return "Software Tycoon";
	}

}
