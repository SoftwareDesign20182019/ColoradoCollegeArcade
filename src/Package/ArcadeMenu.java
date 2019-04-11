package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArcadeMenu extends Application {

	private Stage primaryStage;
	private Arcade arcade;
	
	public ArcadeMenu() {
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		
		Parent root = loader.load();
		//Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		primaryStage.setTitle("Menu");
		primaryStage.setScene(new Scene(root, 600,700));
		
		MenuController controller = loader.<MenuController>getController();
		controller.setArcade(arcade);
		
		primaryStage.show();
		
	}
	
	public void setArcade(Arcade arcade) {
		this.arcade = arcade;
	}

    public static void main(String[] args) {
		launch(args);
	}
}
