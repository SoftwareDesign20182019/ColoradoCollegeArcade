package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Implementation of the game interface for the Rectangle Man game
 * @author ellaneurohr
 *
 */
public class RectangleMan extends Application implements Game{

	private Stage rectangleManStage;
	private Arcade arcade;
	private int score;

	/**
	 * Loads the fxml and sets up the controller
	 * @param primaryStage - the new stage for this fxml file
	 */
	@Override
	public void start(Stage rectangleManStage) throws Exception {
		this.rectangleManStage = rectangleManStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RectangleMan.fxml"));
		Parent root = loader.load();
		RectangleManController controller = loader.<RectangleManController>getController();
		controller.initData(this);
		rectangleManStage.setTitle("Rectangle Man!");
		rectangleManStage.setScene(new Scene(root, 790,400));
		rectangleManStage.show();
	}

	/**
	 * Calls the start method
	 * Gets called from the main arcade class
	 * @param stage - the new stage for this game
	 * @param arcade - the instance of the arcade
	 * @return int - the score
	 * @throws Exception
	 */
	@Override
	public int playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
		return 0;
	}

	/**
	 * Sets the score of the game
	 * @param score - the game score
	 */
	public void setScore(int score){
		this.score = score;
	}

	/**
	 * The display name of the game
	 * @return String - game name
	 */
	@Override
	public String getGameName() {
		return "Rectangle Man";
	}

	/**
	 * calls the arcade method to end the game and prompt name selection
	 * @throws Exception
	 */
	@Override
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		rectangleManStage.close();
	}

	/**
	 * The database name of the game
	 * @return String - game name
	 */
	public String toString(){
		return "RectangleMan";
	}
}
