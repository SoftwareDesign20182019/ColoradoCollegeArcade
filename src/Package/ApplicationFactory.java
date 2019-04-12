package Package;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for the factory that switches to the user-selected application
 */
public class ApplicationFactory {

    public Game selectGame(int userChoice) throws Exception {
        switch (userChoice) {
            case 1:
                RandomScore randomScore = new RandomScore();
                return randomScore;
            case 2:
            	JavelinGame javelinGame = new JavelinGame();
            	return javelinGame;
            default:
                return null;
        }
    }
}