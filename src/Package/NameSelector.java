package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for a name selector
 * @author ellaneurohr
 *
 */
public class NameSelector extends Application {

	private String name;
	private Stage primaryStage;
	private Arcade arcade;

	/**
	 * Loads the fxml and sets up the controller
	 * @param primaryStage - the new stage for this fxml file
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EnterName.fxml"));
		Parent root = loader.load();
		NameSelectorController controller = loader.<NameSelectorController>getController();
		controller.initData(this);
		primaryStage.setTitle("Enter Name");
		primaryStage.setScene(new Scene(root, 600, 700));
		primaryStage.show();
	}

	/**
	 * Calls the start method
	 * Used in the arcade class to open the name selector stage
	 * @param stage - the new stage
	 * @param arcade - the instance of the arcade class
	 * @return String - the name selected
	 * @throws Exception
	 */
	public String openNameSelector(Stage stage, Arcade arcade) throws Exception {
		this.arcade = arcade;
		start(stage);
		return name;
	}

	/**
	 * Called from the controller
	 * Sets the name for this class based on user input
	 * @param name - the user selected name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Calls the next window in arcade
	 * @throws Exception
	 */
	public void finishGame() throws Exception {
		arcade.displayHighScores(name);
	}

	/**
	 * Overrides the fxml process to close this game stage
	 */
	@Override
	public void stop(){
		primaryStage.close();
	}

}
