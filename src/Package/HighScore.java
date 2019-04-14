package Package;

import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighScore extends Application {


	private Stage primaryStage;
	private Arcade arcade;
	
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

	public void displayHighScores(Stage stage, Arcade arcade) throws Exception{
		this.arcade = arcade;
		start(stage);
	}

	public HashMap<String, String> getHighScores(){
		return arcade.getHighScores();
	}

	public String getGameName(){
		return arcade.getGameName();
	}
	
	@Override
	public void stop(){
		primaryStage.close();
	}


}
