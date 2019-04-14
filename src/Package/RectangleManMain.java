package Package;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RectangleManMain extends Application {

	Stage rectangleManStage;
	
	@Override
	public void start(Stage rectangleManStage) throws Exception {
		
		this.rectangleManStage = rectangleManStage;
		FXMLLoader recloader = new FXMLLoader(getClass().getResource("RectangleMan.fxml"));
		Parent rectangleManRoot = recloader.load();
		rectangleManStage.setTitle("Rectangle Man");
		rectangleManStage.setScene(new Scene(rectangleManRoot, 800,400));
		rectangleManStage.setResizable(false);
		rectangleManStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
