package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Window;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class MenuController {
	
	private ArcadeMenu arcadeMenu;
	private int selection = 1;
	private int choice;
	
	@FXML
	private Rectangle selectorRec;
	
	
	public void setArcadeMenu(ArcadeMenu arcadeMenu)
	{
		this.arcadeMenu = arcadeMenu;
	}
	
	@FXML
	public void handleButtonPress(ActionEvent event) {
		System.out.println("I AM WILL");
	}
	
	@FXML
	private void handleKeyPress(KeyEvent e)
	{
		
		//ENTER
		if (e.getCode() == KeyCode.ENTER)
		{
			choice = selection;
			System.out.println("CHOICE: "+choice);
		}
		//DOWN
		else if (e.getCode() == KeyCode.S && selection == 3 ) {
			selectorRec.setY(200);
			selection += 1;
		}
		else if (e.getCode() == KeyCode.S && selection == 2 ) {
			selectorRec.setY(170);
			selection += 1;
		}
		else if (e.getCode() == KeyCode.S && selection == 1 ) {
			selectorRec.setY(140);
			selection += 1;
		}
		
		//UP
		else if (e.getCode() == KeyCode.W && selection == 2 ) {
			selectorRec.setY(110);
			selection -= 1;
		}
		else if (e.getCode() == KeyCode.W && selection == 3 ) {
			selectorRec.setY(140);
			selection -= 1;
		}
		else if (e.getCode() == KeyCode.W && selection == 4 ) {
			selectorRec.setY(170);
			selection -= 1;
		}
		
	}
	
}
