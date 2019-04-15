package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class JavelinThrow extends Application implements Game {
	
	private Stage primaryStage;
	private int score;
	private Arcade arcade;
	boolean isGameDone;

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
		return "javelinThrow";
	}
	
    public String getGameName() {
    	return "Javelin Throw";
    }
    
    public boolean isGameDone() {
    	return isGameDone;
    }

	public void setGameToDone() throws Exception {
    	arcade.gameUpdate(score);
    }
	
	public void stop() {
		primaryStage.close();
	}
}
