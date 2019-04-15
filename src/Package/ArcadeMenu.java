package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * class for the creation of the javaFX game menu
 *
 */
public class ArcadeMenu extends Application {

	@SuppressWarnings("unused")
	private Stage primaryStage;


	/**
	 * Overridden method from Application parent
	 * connects the FXML file to the stage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		Parent root = loader.load();
		MenuController controller = loader.<MenuController>getController();
		controller.initData(this);
		primaryStage.setTitle("Menu");
		primaryStage.setScene(new Scene(root, 600,700));
		primaryStage.show();
	}

	/**
	 * main method for launching the application
	 * @param args empty
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
