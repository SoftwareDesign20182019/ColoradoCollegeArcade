package Package;

import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	
	public int playGame(Stage stage) throws Exception {
		start(stage);
		return 0;
	}

	public String toString() {
		return "javelinThrow";
	}
	
    public String getName() {
    	Random r = new Random();
    	String name = "";
    	for (int i = 0; i < 3; i++) {
    		char letterInName = (char)(r.nextInt(26) + 'a');
    		name = name + letterInName;
    	}
    	return name;
    }
}
