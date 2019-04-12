package Package;
import javafx.fxml.*;
import javafx.scene.control.Label;

public class HighScoreScreenController {

    @FXML
    private Label GameNameLabel;

    public void initData(String gameName)
    {
        GameNameLabel.setText(gameName);
    }

}
