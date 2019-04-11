package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArcadeMenu extends Application {

	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		this.primaryStage = primaryStage;
		
	
		Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		primaryStage.setTitle("Menu");
		primaryStage.setScene(new Scene(root, 600,700));
		
		
		primaryStage.show();
		
	}


    public static void main(String[] args) {
		launch(args);
	}
}
