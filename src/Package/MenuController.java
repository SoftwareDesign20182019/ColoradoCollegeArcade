package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

/**
 * Controller class for the game select menu view
 */
public class MenuController {

	@SuppressWarnings("unused")
	private ArcadeMenu arcadeMenu;
	private int selection = 1;
	private int choice;
	private Arcade arcade;
	private int cursor = 0;
	private int diff = 40;
	private static final int JAVELIN_THROW   = 1;
	private static final int RECTANGLE_MAN   = 2;
	private static final int SUPER_VACUUM    = 3;
	private static final int SOFTWARE_TYCOON = 4;
	private static final int FISHER_MAN      = 5;
	private static final int QUIT            = 6;

	@FXML
	private Rectangle selectorRec;
	@FXML
	private ImageView javelinThrowPhoto;
	@FXML
	private ImageView rectangleManPhoto;
	@FXML
	private ImageView superVacuumPhoto;
	@FXML
	private ImageView clickerGamePhoto;
	@FXML
	private ImageView fisherManPhoto;
	@FXML
	private Rectangle selector;


	/**
	 * simple constructor creates an instance of an arcade
	 */
	public MenuController() {
		arcade = new Arcade();
	}

	public void down() {
		cursor += diff;
		selectorRec.setY(cursor);
		selection++;
	}

	public void up() {
		cursor -= diff;
		selectorRec.setY(cursor);
		selection--;
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
			if (choice == QUIT)
				System.exit(0);
			arcade.runNewGame(choice);
		}
		//DOWN
		else if(e.getCode() == KeyCode.S)
		{
			if(selection == JAVELIN_THROW)
			{
				javelinThrowPhoto.setVisible(false);
				rectangleManPhoto.setVisible(true);
				down();
			}
			else if(selection == RECTANGLE_MAN)
			{
				rectangleManPhoto.setVisible(false);
				superVacuumPhoto.setVisible(true);

				down();
			}
			else if(selection == SUPER_VACUUM)
			{
				superVacuumPhoto.setVisible(false);
				//				clickerGamePhoto.setVisible(true);
				down();
			}
			else if(selection == SOFTWARE_TYCOON)
			{
				//				clickerGamePhoto.setVisible(false);
				fisherManPhoto.setVisible(true);
				down();
			}
			else if(selection == FISHER_MAN)
			{
				fisherManPhoto.setVisible(false);
				selector.setVisible(false);
				down();
			}
			else if(selection == QUIT)
			{
			}
		}
		//UP
		else if(e.getCode() == KeyCode.W)
		{
			if(selection == RECTANGLE_MAN)
			{
				rectangleManPhoto.setVisible(false);
				javelinThrowPhoto.setVisible(true);
				up();
			}
			else if(selection == SUPER_VACUUM)
			{
				superVacuumPhoto.setVisible(false);
				rectangleManPhoto.setVisible(true);
				up();
			}
			else if(selection == SOFTWARE_TYCOON)
			{
				//				clickerGamePhoto.setVisible(false);
				superVacuumPhoto.setVisible(true);
				up();
			}
			else if(selection == FISHER_MAN)
			{
				fisherManPhoto.setVisible(false);
				//				clickerGamePhoto.setVisible(true);
				up();
			}
			else if(selection == QUIT)
			{
				fisherManPhoto.setVisible(true);
				selector.setVisible(true);
				up();
			}
		}
	}

	public void initData(ArcadeMenu arcadeMenu) {
		this.arcadeMenu = arcadeMenu;

	}
}
