package Package;

import javafx.application.Platform;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * controller for fisherman game
 * @author hrose
 *
 */
public class FishermanController {
	
	private FishermanMain fishermanMain;
	
	@FXML
	Line line;
	@FXML
	Circle bob;
	@FXML
	ImageView fisherman;
	@FXML
	ImageView fisherman2;
	@FXML
	ImageView fish;
	@FXML
	Line line2;
	@FXML
	Label label;
	@FXML
	Label instructions;

	private boolean fishOn = false;
	private boolean caught = false;
	private boolean done = false;
	int pulls;
	int presses;
	int score;
	
	Timer timer = new Timer();
	
	/**
	 * Starts the game
	 */
	public void startGame() {
		TimerTask task = new TimerTask() {
			/**
			 * runner method - sets fishBite
			 */
			public void run()
			{
				fishBite();
			}
		};
		timer.schedule(task, 10000l);
	}
	
	/**
	 * The fish biting the bob
	 */
	public void fishBite()
	{
		bob.setVisible(false);
		fishOn = true;
	}
	
	/**
	 * method for the switching of fisherman views
	 * @throws Exception for javaFX related exceptions
	 */
	public void catchFish() throws Exception
	{
		fisherman.toBack();
		fisherman2.toFront();
		bob.setCenterY(300);
		bob.setVisible(true);
		line.setEndY(300);
		line2.setEndY(300);
		line2.setStartY(330);
		fish.toFront();
		line2.toFront();
		TranslateTransition fishUp = new TranslateTransition(Duration.millis(200), fish);
		fishUp.setByY(-200);
		fishUp.play();
		endGame();
	}
	
	/**
	 * Does end of game displays 
	 * @throws Exception
	 */
	public void endGame() throws Exception
	{
		Random random = new Random();
		score = random.nextInt(80);
		score += 20;
		instructions.setText("Press Enter to Continue");
		instructions.setVisible(true);
		label.setText("Your Fish is " + score + "cm!");
		label.setVisible(true);
		done = true;
	}
	
	/**
	 * checks if fish is on line yet
	 * @throws Exception for JavaFX related exception
	 */
	public void checkCatch() throws Exception {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					if (presses > pulls && !caught)
					{
						caught = true;
						fishOn = false;
						try {
							catchFish();
						} catch (Exception e) {}
					}
				});
			}
		}, 0l,50l);
	}
	
	@FXML
	/**
	 * helps the javaFX stage run
	 * @param event the empty button push
	 */
	public void handleButtonPress(ActionEvent event)
	{
		
	}
	
	@FXML
	/**
	 * method for catching and handling button presses
	 * @param e the keyevent
	 * @throws Exception
	 */
	public void handleKeyPress(KeyEvent e) throws Exception
	{
		if (e.getCode() == KeyCode.ENTER)
		{
			label.setVisible(false);
			instructions.setVisible(false);
			Random random = new Random();
			pulls = random.nextInt(10);
			pulls += 5;
			startGame();
			checkCatch();
		}
		if(e.getCode() == KeyCode.ENTER && done)
		{
			fishermanMain.setScore(score);
			fishermanMain.setGameToDone();
		}
		if (e.getCode() == KeyCode.L && fishOn)
		{
			presses += 1;
			fisherman2.toFront();
			fisherman.toBack();
		}
	}
	
	@FXML
	/**
	 * method for catching and handling button releases
	 * @param e the keyevent
	 */
	public void handleKeyRelease(KeyEvent e)
	{
		if (e.getCode() == KeyCode.L)
		{
			fisherman.toFront();
			fisherman2.toBack();
		}
	}
	
	/**
	 * feeds the view to the controller
	 * @param fishermanMain the view to be fed in
	 */
	public void initData(FishermanMain fishermanMain) {
		this.fishermanMain = fishermanMain;
	}
}
