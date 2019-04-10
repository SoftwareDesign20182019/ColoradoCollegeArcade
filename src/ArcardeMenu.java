import java.io.IOException;

import com.sun.tools.javac.Main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ArcardeMenu extends Application {

	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow() {
		
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/MenuFXML.fxml"));
			AnchorPane pane = loader.load();
			MenuController menuController = loader.getController();
			
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
