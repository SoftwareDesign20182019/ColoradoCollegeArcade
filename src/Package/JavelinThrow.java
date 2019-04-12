package Package;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavelinThrow extends Application implements Game {
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Javelin.fxml"));
		Parent root = loader.load();
		primaryStage.setTitle("Javelin Throw!");
		primaryStage.setScene(new Scene(root, 790,400));
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public int playGame() {
		String[] args = {};
		main(args);
		return 0;
	}

	public String toString() {
		return "javelinThrow";
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
