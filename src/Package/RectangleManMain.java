package Package;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RectangleManMain extends Application implements Game{

	private Stage rectangleManStage;
	private Arcade arcade;
	private int score;
	
	@Override
	public void start(Stage rectangleManStage) throws Exception {
		
//		this.rectangleManStage = rectangleManStage;
//		FXMLLoader recloader = new FXMLLoader(getClass().getResource("RectangleMan.fxml"));
//		Parent rectangleManRoot = recloader.load();
//		rectangleManStage.setTitle("Rectangle Man");
//		rectangleManStage.setScene(new Scene(rectangleManRoot, 800,400));
//		rectangleManStage.setResizable(false);
//		rectangleManStage.show();

		this.rectangleManStage = rectangleManStage;
//		isGameDone = false;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("RectangleMan.fxml"));
		Parent root = loader.load();
		RectangleManController controller = loader.<RectangleManController>getController();
		controller.initData(this);
		rectangleManStage.setTitle("Rectangle Man!");
		rectangleManStage.setScene(new Scene(root, 790,400));
		rectangleManStage.show();
	}


	@Override
	public int playGame(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
		return 0;
	}

	public void setScore(int score){
		this.score = score;
	}

	@Override
	public String getGameName() {
		return "Rectangle Man";
	}

	@Override
	public boolean isGameDone() {
		return false;
	}

	@Override
	public void setGameToDone() throws Exception {
		arcade.gameUpdate(score);

	}

	public String toString(){
		return "RectangleMan";
	}

	@Override
	public void stop(){
		System.out.println("Stage is closing");
		// Save file
	}
}
