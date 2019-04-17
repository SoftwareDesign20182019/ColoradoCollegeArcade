package Package;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Game implementation for Super Vacuum
 * @author ellaneurohr
 *
 */
public class SuperVacuum extends Application implements Game {

	private Stage superVacuumStage;
	private Arcade arcade;
	private int score;
	
	/**
	 * Loads the fxml and sets up the controller
	 * @param primaryStage - the new stage for this fxml file
	 */
	@Override
	public void start(Stage superVacuumStage) throws Exception {
		this.superVacuumStage = superVacuumStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SuperVacuumFXML.fxml"));
		Parent root = loader.load();
		SuperVacuumController controller = loader.<SuperVacuumController>getController();
		controller.initData(this);
		superVacuumStage.setTitle("Super Vacuum!");
		superVacuumStage.setScene(new Scene(root, 600,700));
		superVacuumStage.show();
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
		return "Super Vacuum";
	}
	
	/**
	 * The database name of the game
	 * @return String - game name
	 */
	public String toString() {
		return "SuperVacuum";
	}

	/**
	 * calls the arcade method to end the game and prompt name selection
	 * @throws Exception
	 */
	@Override
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		superVacuumStage.close();
	}

	/**
	 * Sets the score of the game
	 * @param score - the game score
	 */
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}
