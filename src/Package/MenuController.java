package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class MenuController {
	
	private ArcadeMenu arcadeMenu;
	private int selection = 1;
	private int choice;
	private Arcade arcade;
	
	@FXML
	private Rectangle selectorRec;

	public MenuController() {
		arcade = new Arcade();
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
			if (choice == 5)
				System.exit(0);
			arcade.runNewGame(choice);
		}
		//DOWN
		else if (e.getCode() == KeyCode.S && selection == 4) {
			selectorRec.setY(230);
			selection++;
		} else if (e.getCode() == KeyCode.S && selection == 3 ) {
			selectorRec.setY(200);
			selection++;
		} else if (e.getCode() == KeyCode.S && selection == 2 ) {
			selectorRec.setY(170);
			selection++;
		} else if (e.getCode() == KeyCode.S && selection == 1 ) {
			selectorRec.setY(140);
			selection++;
		}


		//UP
		else if (e.getCode() == KeyCode.W && selection == 2 ) {
			selectorRec.setY(110);
			selection--;
		} else if (e.getCode() == KeyCode.W && selection == 3 ) {
			selectorRec.setY(140);
			selection--;
		} else if (e.getCode() == KeyCode.W && selection == 4 ) {
			selectorRec.setY(170);
			selection--;
		} else if (e.getCode() == KeyCode.W && selection == 5) {
			selectorRec.setY(200);
			selection--;
		}
		
	}
	
}
