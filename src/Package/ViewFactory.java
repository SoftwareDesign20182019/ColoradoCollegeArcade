package Package;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ViewFactory {
	public void openView(int userChoice) throws Exception {
        switch (userChoice) {
        case 1:
        	break;
        case 2:
        	JavelinGame javelinGame = new JavelinGame();
        	
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Javelin.fxml"));
    		Parent javelinRoot = loader.load();
    		JavelinController controller = loader.<JavelinController>getController();
    		controller.initData(javelinGame);
    		Stage javelinStage = new Stage();
    		javelinStage.setTitle("Javelin Game");
    		javelinStage.setScene(new Scene(javelinRoot, 800,400));
    		javelinStage.show();
    		break;
        default:
            break;
        }
	}
}
