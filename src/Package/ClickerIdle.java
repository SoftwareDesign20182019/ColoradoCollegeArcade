package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class ClickerIdle extends Application implements Game {

	private Stage primaryStage;
	private int score;
	private Arcade arcade;
	boolean isGameDone;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		isGameDone = false;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Clicker.fxml"));
		Parent root = loader.load();
		ClickerController controller = loader.<ClickerController>getController();
		controller.initData(this);
		primaryStage.setTitle("ClickerIdle");
		primaryStage.setScene(new Scene(root, 600,700));
		primaryStage.show();
	}

	public int playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
		return score;
	}

	public void setScore(int score) {
		System.out.println("Score is: " + score);
		this.score = score;
	}

	public String toString() {
		return "clickerIdle";
	}

	public String getName() {
		return "TST";
	}

	public boolean isGameDone() {
		return isGameDone;
	}

	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
	}

	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return null;
	}

}
