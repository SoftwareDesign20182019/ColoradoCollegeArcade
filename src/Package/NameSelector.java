package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NameSelector extends Application {

    private String name;
    private Stage primaryStage;
    private Arcade arcade;

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

    public String openNameSelector(Stage stage, Arcade arcade) throws Exception {
        this.arcade = arcade;
        start(stage);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void finishGame() throws Exception {
        arcade.finishGame(name);
    }
    
	@Override
	public void stop(){
		primaryStage.close();
	}

}
