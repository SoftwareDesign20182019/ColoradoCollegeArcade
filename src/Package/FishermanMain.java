package Package;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FishermanMain extends Application implements Game {

	private Stage fishermanStage;
	private Arcade arcade;
	private int score;
	
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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
	}

	@Override
	public String getGameName() {
		return "Fisherman";
	}

	@Override
	public void setGameToDone() throws Exception {
		arcade.endGameToNameChoice(score);
		fishermanStage.close();
	}

	@Override
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Fisherman";
	}
}
