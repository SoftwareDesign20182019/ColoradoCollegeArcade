package Package;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SuperVacuum extends Application {

	Stage superVacuumStage;
	
	@Override
	public void start(Stage superVacuumStage) throws Exception {
		
		this.superVacuumStage = superVacuumStage;
		FXMLLoader vacuumLoader = new FXMLLoader(getClass().getResource("SuperVacuumFXML.fxml"));
		Parent vacuumRoot = vacuumLoader.load();
		superVacuumStage.setTitle("Super Vaccum");
		superVacuumStage.setScene(new Scene(vacuumRoot, 600,700));
		superVacuumStage.setResizable(true);
		superVacuumStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
