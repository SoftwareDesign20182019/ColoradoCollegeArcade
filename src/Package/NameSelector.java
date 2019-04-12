package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NameSelector extends Application {

    private String name;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HighScores.fxml"));
        primaryStage.setTitle("High Scores");
        primaryStage.setScene(new Scene(root, 600, 700));
        primaryStage.show();

        Stage stage = new Stage();

        Parent hi = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
        stage.setTitle("Enter Name");
        stage.setScene(new Scene(hi, 600, 700));
        stage.show();
    }

    public String openNameSelector(Stage stage) throws Exception {
        start(stage);
        return name;
    }

}
