package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.*;

/**
 * NameSelectorController class for the name selector GUI
 */
public class HighScoreController {

	private HighScore highScore;
	private HashMap<String, String> highScores;
	private int selection;

	@FXML
	private Label instructions;
	@FXML
	private Label continueInstructions;
	@FXML
	private Label name1;
	@FXML
	private Label name2;
	@FXML
	private Label name3;
	@FXML
	private Label name4;
	@FXML
	private Label name5;
	@FXML
	private Label name6;
	@FXML
	private Label name7;
	@FXML
	private Label name8;
	@FXML
	private Label name9;
	@FXML
	private Label name10;

	@FXML
	private Label score1;
	@FXML
	private Label score2;
	@FXML
	private Label score3;
	@FXML
	private Label score4;
	@FXML
	private Label score5;
	@FXML
	private Label score6;
	@FXML
	private Label score7;
	@FXML
	private Label score8;
	@FXML
	private Label score9;
	@FXML
	private Label score10;

	/**
	 * Gets the hashmap of the high scores from the HighScore class
	 * @return hashmap of high scores
	 */
	public HashMap<String, String> getHighScores(){
		return highScore.getHighScores();
	}

	/**
	 * Gets the display game name from the HighScore class
	 * @return - the game name to be displayed
	 */
	public String getGameName(){
		return highScore.getGameName();
	}


	/**
	 * Button press event necessary for functionality because of weird button bug
	 * @param event - button press
	 */
	@FXML
	public void handleButtonPress(ActionEvent event) {
	}

	/**
	 * Handles key presses and does different actions based on the key pressed and the state
	 * @param e - the key event
	 * @throws Exception 
	 */
	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception {
		if(e.getCode() == KeyCode.ENTER && selection == 0)
		{
			instructions.setText(getGameName());
			highScores = getHighScores();
			continueInstructions.setText("Press P to play again or Enter to return to main menu");
			Set<String> keySet = highScores.keySet();
			ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
			Collection<String> values = highScores.values();
			ArrayList<String> listOfValues = new ArrayList<String>(values);
			selection++;
			try {
				name1.setText(listOfKeys.get(0));
				score1.setText(listOfValues.get(0));

				name2.setText(listOfKeys.get(1));
				score2.setText(listOfValues.get(1));

				name3.setText(listOfKeys.get(2));
				score3.setText(listOfValues.get(2));

				name4.setText(listOfKeys.get(3));
				score4.setText(listOfValues.get(3));

				name5.setText(listOfKeys.get(4));
				score5.setText(listOfValues.get(4));

				name6.setText(listOfKeys.get(5));
				score6.setText(listOfValues.get(5));

				name7.setText(listOfKeys.get(6));
				score7.setText(listOfValues.get(6));

				name8.setText(listOfKeys.get(7));
				score8.setText(listOfValues.get(7));

				name9.setText(listOfKeys.get(8));
				score9.setText(listOfValues.get(8));

				name10.setText(listOfKeys.get(9));
				score10.setText(listOfValues.get(9));
			} catch (Exception x){}
		}
		else if(e.getCode() == KeyCode.ENTER && selection == 1)
		{
			highScore.stop();
		}
		else if(e.getCode() == KeyCode.P && selection == 1)
		{
			highScore.stop();
			highScore.playAgain();
		}
	}

	/**
	 * Allows the main HighScore class to be passed in to this controller
	 * Necessary for backwards retrieval of data
	 * @param highScore - the instance of the HighScore class
	 */
	public void initData(HighScore highScore) {
		this.highScore = highScore;
	}
}
