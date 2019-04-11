package Package;
import java.io.IOException;
import com.sun.tools.javac.Main;

import javafx.application.*;
import javafx.stage.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
