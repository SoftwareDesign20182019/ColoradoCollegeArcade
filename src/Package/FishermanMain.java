package Package;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FishermanMain extends Application {

	private Stage fishermanStage;
	
	@Override
	public void start(Stage fishermanStage) throws Exception {
		this.fishermanStage = fishermanStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Fisherman.fxml"));
		Parent root = loader.load();
		//SuperVacuumController controller = loader.<SuperVacuumController>getController();
		//controller.initData(this);
		fishermanStage.setTitle("Fisherman");
		fishermanStage.setScene(new Scene(root, 600,600));
		fishermanStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
