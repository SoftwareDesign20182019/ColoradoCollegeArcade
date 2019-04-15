package Package;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * Class for the factory that switches to the user-selected game
 */
public class GameFactory {

    public Game selectGame(int userChoice) throws Exception {
        switch (userChoice) {
            case Arcade.JAVELIN_THROW:
            	JavelinThrow javelinGame = new JavelinThrow();
                return javelinGame;
            case Arcade.RECTANGLE_MAN:
                RectangleManMain rectangleManMain = new RectangleManMain();
                return rectangleManMain;
            case Arcade.SUPER_VACUUM:
            	return null;
            case Arcade.CLICKER_GAME:
            	//ClickerIdle clickerIdle = new ClickerIdle(); currently in development, ignore!
            	//return clickerIdle;
            	return null;
            default:
                return null;
        }
    }
}