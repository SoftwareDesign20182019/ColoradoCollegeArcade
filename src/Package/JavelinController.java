package Package;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


/**
 * Controller for the Javelin Throw fxml file
 * @author ellaneurohr
 *
 */
public class JavelinController {
	
	@FXML
	ImageView javelinMan;
	
	@FXML
	Rectangle javelin;
	
	@FXML
	Label instructionLabel1;
	
	@FXML
	Label instructionLabel2;
	
	@FXML
	Label instructionLabel3;
	
	@FXML
	Rectangle powerBar;
	
	@FXML
	Rectangle accuracyBar;

	private int sequence = 1;
	private int power;
	private int accuracy;
	private int total;
	private int distance;
	private JavelinThrow game;
	
	SequentialTransition powerBarSequence;
	SequentialTransition accuracyBarSequence;
	SequentialTransition throwJavelin;
	
	/**
	 * Handles the button press
	 * Necessary for weird button bug
	 * @param event
	 */
	@FXML
	public void handleButtonPress(ActionEvent event){}
	
	/**
	 * Calls methods to deal with key presses
	 * @param e
	 * @throws Exception
	 */
	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception
	{
		instructionLabel1.setVisible(false);
		instructionLabel2.setVisible(false);
		instructionLabel3.setVisible(false);
		if (e.getCode() == KeyCode.S && sequence == 1)
		{
			powerBarAnimation();
			sequence++;
		}	
		else if (e.getCode() == KeyCode.S && sequence == 2)
		{
			powerBarStop();
			accuracyBarAnimation();
			sequence++;
		}
		else if (e.getCode() == KeyCode.S && sequence == 3) {
			accuracyBarStop();
			moveJavelinMan();
			displayScore();
			sequence++;
		} else if (e.getCode() == KeyCode.ENTER && sequence == 4) {
			returnScore();
			sequence++;
		}
	}


	/**
	 * Allows the main JavelinThrow class to be passed in to this controller
	 * Necessary for backwards retrieval of data
	 * @param game - the instance of the JavelinThrow class
	 */
	public void initData(JavelinThrow game) {
		this.game = game;
	}

	/**
	 * Animation method for moving the man
	 */
	private void moveJavelinMan() {
		throwJavelin = new SequentialTransition();
		
		ParallelTransition javelinAndManTransition = new ParallelTransition();
		ParallelTransition javelinUpRight = new ParallelTransition();
		ParallelTransition javelinDownRight = new ParallelTransition();
		
		distance = total*5;
		
		//translates javelin man right
		TranslateTransition javelinManTransition = new TranslateTransition(Duration.millis(2000), javelinMan);
		javelinManTransition.setByX(75);
		//translates javelin with man
		TranslateTransition javelinTransition = new TranslateTransition(Duration.millis(2000), javelin);
		javelinTransition.setByX(75);
		//translates javelin up
		TranslateTransition javelinUp = new TranslateTransition(Duration.millis(1000), javelin);
		javelinUp.setByY(-80);
		//translates javelin down
		TranslateTransition javelinDown = new TranslateTransition(Duration.millis(1000), javelin);
		javelinDown.setByY(100);
		//translates javelin right through the air
		TranslateTransition javelinRight = new TranslateTransition(Duration.millis(1000), javelin);
		javelinRight.setByX(distance / 2);
		//rotates the javelin
		RotateTransition javelinRotate = new RotateTransition(Duration.millis(1000), javelin);
		javelinRotate.setByAngle(45);

		
		javelinAndManTransition.getChildren().addAll(javelinManTransition, javelinTransition);
		javelinUpRight.getChildren().addAll(javelinUp, javelinRight, javelinRotate);
		javelinDownRight.getChildren().addAll(javelinDown, javelinRight, javelinRotate);
		
		throwJavelin.getChildren().addAll(javelinAndManTransition, javelinUpRight, javelinDownRight);
		throwJavelin.play();
	}

	/**
	 * Method for displaying the final score
	 */
	private void displayScore() {
		String newLabel = "You Scored: " + total + "! (Game Over) Press Enter to Continue";
		instructionLabel2.setText(newLabel);
		
		ParallelTransition labelMove = new ParallelTransition();
		SequentialTransition labelFadeIn = new SequentialTransition();
		
		TranslateTransition labelStall = new TranslateTransition(Duration.millis(4000), instructionLabel2);
		labelStall.setByY(175);
		
		FadeTransition keepLabelInvisible = new FadeTransition(Duration.millis(4000), instructionLabel2);
		keepLabelInvisible.setFromValue(0.0);
		keepLabelInvisible.setToValue(0.0);
		keepLabelInvisible.setCycleCount(1);
		
		FadeTransition labelFade = new FadeTransition(Duration.millis(200), instructionLabel2);
		labelFade.setFromValue(0.0);
		labelFade.setToValue(1.0);
		labelFade.setCycleCount(1);
		
		labelMove.getChildren().addAll(labelStall, keepLabelInvisible);
		labelFadeIn.getChildren().addAll(labelMove, labelFade);
		labelFadeIn.play();
		instructionLabel2.setVisible(true);
	}
	
	/**
	 * Animates the power bar so it can go up then down
	 */
	private void powerBarAnimation()
	{
		powerBarSequence = new SequentialTransition();
		
		ScaleTransition powerBarUp = new ScaleTransition(Duration.millis(500), powerBar);
		powerBarUp.setToY(20f);
		ScaleTransition powerBarUp2 = new ScaleTransition(Duration.millis(500), powerBar);
		powerBarUp2.setToY(20f);
		
		ScaleTransition powerBarDown = new ScaleTransition(Duration.millis(500), powerBar);
		powerBarDown.setToY((1/20f));
		ScaleTransition powerBarDown2 = new ScaleTransition(Duration.millis(500), powerBar);
		powerBarDown2.setToY((1/20f));
		
		powerBarSequence.getChildren().addAll(powerBarUp, powerBarDown, powerBarUp2, powerBarDown2);
		powerBarSequence.play();
	}
	
	/**
	 * Animation so the power bar stops on the s key press
	 */
	private void powerBarStop()
	{	
		powerBarSequence.stop();
		power = (int) powerBar.computeAreaInScreen();
		power = power/13;
		power = (int) (power/4.3);
		if (power < 99)
		{
			power++;
		}
	}
	
	/**
	 * Animation for the accuracy bar
	 */
	private void accuracyBarAnimation()
	{
		accuracyBarSequence = new SequentialTransition();
		
		TranslateTransition accuracyBarRight = new TranslateTransition(Duration.millis(400), accuracyBar);
		accuracyBarRight.setByX(200);
		TranslateTransition accuracyBarRight2 = new TranslateTransition(Duration.millis(400), accuracyBar);
		accuracyBarRight2.setByX(200);
		TranslateTransition accuracyBarRight3 = new TranslateTransition(Duration.millis(400), accuracyBar);
		accuracyBarRight3.setByX(200);
		
		TranslateTransition accuracyBarLeft = new TranslateTransition(Duration.millis(400), accuracyBar);
		accuracyBarLeft.setByX(-200);
		TranslateTransition accuracyBarLeft2 = new TranslateTransition(Duration.millis(400), accuracyBar);
		accuracyBarLeft2.setByX(-200);
		TranslateTransition accuracyBarLeft3 = new TranslateTransition(Duration.millis(400), accuracyBar);
		accuracyBarLeft3.setByX(-200);
		
		accuracyBarSequence.getChildren().addAll(accuracyBarRight, accuracyBarLeft, accuracyBarRight2, accuracyBarLeft2, accuracyBarRight3, accuracyBarLeft3);
		accuracyBarSequence.play();
	}
	
	/**
	 * Stops the accuracy bar animation
	 */
	private void accuracyBarStop()
	{
		accuracyBarSequence.stop();
		if(accuracyBar.getTranslateX() > 100)
		{
			accuracy = (int) accuracyBar.getTranslateX();
			accuracy = accuracy - 100;
			accuracy = 100 - accuracy;
		}
		else
		{
			accuracy = (int) accuracyBar.getTranslateX();
			accuracy = 100 - accuracy;
			accuracy = 100 - accuracy;
		}
		total = (accuracy + power) / 2;
	}

	/**
	 * Returns the score to the JavelinThrow class and stops the game
	 * @throws Exception
	 */
	private void returnScore() throws Exception {
		game.setScore(total);
		game.setGameToDone();
		game.stop();
	}
	


}
