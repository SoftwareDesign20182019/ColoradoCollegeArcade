package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.scene.control.Label;

public class MenuController {
	
	private ArcadeMenu arcadeMenu;
	private int selection = 1;
	
	public void setArcadeMenu(ArcadeMenu arcadeMenu)
	{
		this.arcadeMenu = arcadeMenu;
	}
	
	@FXML
	private Label label;
	
	@FXML
	private void handleButtonAction(ActionEvent event)
	{
		System.out.println("I AM WILL");
	}
	
}
