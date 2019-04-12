package Package;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighScoreScreen extends Application {
    private String gameName;

    HighScoreScreen(String gameName)
    {
        this.gameName = gameName;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "HighScores.fxml"
                )
        );

        Parent root = (Parent) loader.load();

        HighScoreScreenController controller = loader.<HighScoreScreenController>getController();
        controller.initData(gameName);


        //Parent root = FXMLLoader.load(getClass().getResource("HighScores.fxml"));
        primaryStage.setTitle("High Scores");
        primaryStage.setScene(new Scene(root, 600, 700));
        primaryStage.show();

        //Stage stage = new Stage();

        //Parent hi = FXMLLoader.load(getClass().getResource("EnterName.fxml"));
        //stage.setTitle("Enter Name");
        //stage.setScene(new Scene(hi, 600, 700));
        //stage.show();
    }


    //public static void main(String[] args) {
    //    launch(args);
    //   System.out.println("test");
    //}
}
