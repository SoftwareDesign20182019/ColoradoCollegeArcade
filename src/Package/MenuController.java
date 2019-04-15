package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

/**
 * Controller class for the game select menu view
 */
public class MenuController {
	
	private ArcadeMenu arcadeMenu;
	private int selection = 1;
	private int choice;
	private Arcade arcade;
	
	@FXML
	private Rectangle selectorRec;
	
	/**
	 * simple constructor creates an instance of an arcade
	 */
	public MenuController() {
		arcade = new Arcade();
	}
	
	/**
	 * buttonPress handler for pressing the button in menu view
	 * @param event the clicking of the button
	 */
	@FXML
	public void handleButtonPress(ActionEvent event) {

	}
	
	/**
	 * keyPress handler for scrolling through various game options
	 * in the game menu
	 * @param e the keyEvent (pressing of a key)
	 */
	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception
	{

		//ENTER
		if (e.getCode() == KeyCode.ENTER)
		{
			choice = selection;
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
