package Package;

import javafx.application.Platform;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FishermanController {
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

	private boolean fishOn = false;
	private boolean caught = false;
	int pulls;
	int presses;
	int score;
	
	Timer timer = new Timer();
	
	public void startGame() {
		TimerTask task = new TimerTask() {
			public void run()
			{
				fishBite();
			}
		};
		timer.schedule(task, 10000l);
	}
	
	public void fishBite()
	{
		bob.setVisible(false);
		fishOn = true;
	}
	
	public void catchFish()
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
	
	public void endGame()
	{
		timer.cancel();
		Random random = new Random();
		score = random.nextInt(180);
		score += 20;
		label.setText("Your Fish is " + score + "cm!");
		label.toFront();
		
	}
	
	public void checkCatch() {
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					if (presses > pulls && !caught)
					{
						caught = true;
						fishOn = false;
						catchFish();
					}
				});
			}
		}, 0l,50l);
	}
	
	@FXML
	public void handleButtonPress(ActionEvent event)
	{
		
	}
	
	@FXML
	public void handleKeyPress(KeyEvent e)
	{
		if (e.getCode() == KeyCode.ENTER)
		{
			label.toBack();
			Random random = new Random();
			pulls = random.nextInt(10);
			pulls += 5;
			startGame();
			checkCatch();
		}
		if (e.getCode() == KeyCode.F && fishOn)
		{
			presses += 1;
			fisherman2.toFront();
			fisherman.toBack();
		}
	}
	
	@FXML
	public void handleKeyRelease(KeyEvent e)
	{
		if (e.getCode() == KeyCode.F)
		{
			fisherman.toFront();
			fisherman2.toBack();
		}
	}
}
