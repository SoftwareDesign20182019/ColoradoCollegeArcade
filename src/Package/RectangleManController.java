package Package;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class RectangleManController {

	//FXML IMPORTS
	@FXML
	Rectangle rectangleMan;
	@FXML
	Label labelStart;
	@FXML
	Label labelEnd;
	@FXML
	Label labelScore;
	@FXML
	Rectangle badBlock11;
	@FXML
	Rectangle badBlock12;
	@FXML
	Rectangle badBlock2;
	@FXML
	Rectangle badBlock3;
	@FXML
	Rectangle badBlock4;
	@FXML
	Rectangle badBlock51;
	@FXML
	Rectangle badBlock52;
	@FXML
	Rectangle roof;
	
	Random random = new Random();

	private RectangleManMain rectangleManMain;

	private SequentialTransition badBlock11Transition;
	private SequentialTransition badBlock12Transition;
	private ParallelTransition badBlock13Transition;
	private SequentialTransition badBlock2Transition;
	private SequentialTransition badBlock3Transition;
	private SequentialTransition badBlock4Transition;
	private SequentialTransition badBlock51Transition;
	private SequentialTransition badBlock52Transition;
	private ParallelTransition badBlock53Transition;
	
	private boolean hit = false;
	private boolean gameStarted = false;
	private boolean up = true;
	private boolean canMove = true;
	private boolean canExit = false;
	
	private int BOTTOM = 1;
	private int TOP = 3;
	private int position = BOTTOM;
	private int score = 0;
	
	Timer timer = new Timer();
	Timer BB13timer = new Timer();
	Timer BB2timer = new Timer();
	Timer BB3timer = new Timer();
	Timer BB4timer = new Timer();
	Timer BB53timer = new Timer();
	Timer collisionTimer = new Timer();
	Timer scoreTimer = new Timer();
	
	//GAME PIECE MOVEMENTS
	private void jump()
	{
		TranslateTransition goUp = new TranslateTransition(Duration.millis(200), rectangleMan);
		goUp.setByY(-100);
		goUp.play();
	}
	
	private void land()
	{
		TranslateTransition goDown = new TranslateTransition(Duration.millis(200), rectangleMan);
		goDown.setByY(100);
		goDown.play();
	}
	
	private void standUp()
	{
		RotateTransition standUp = new RotateTransition(Duration.millis(200), rectangleMan);
		standUp.setToAngle(0);
		standUp.play();
	}
	
	private void layDown()
	{
		RotateTransition layDown = new RotateTransition(Duration.millis(200), rectangleMan);
		layDown.setToAngle(-90);
		layDown.play();
	}
	
	//STARTS THE ENEMY MOVEMENTS
	private void runEnemies() 
	{
		//INITIALIZES TRANSITIONS
		badBlock11Transition = new SequentialTransition();
		badBlock12Transition = new SequentialTransition();
		badBlock13Transition = new ParallelTransition();
		badBlock2Transition = new SequentialTransition();
		badBlock3Transition = new SequentialTransition();
		badBlock4Transition = new SequentialTransition();
		badBlock51Transition = new SequentialTransition();
		badBlock52Transition = new SequentialTransition();
		badBlock53Transition = new ParallelTransition();
		
		//BAD BLOCK 11 TRANSITION
		TranslateTransition badBlock11Up = new TranslateTransition(Duration.millis(100), badBlock11);
		badBlock11Up.setToY(0);
		TranslateTransition badBlock11Down = new TranslateTransition(Duration.millis(100), badBlock11);
		badBlock11Down.setToY(180);
		TranslateTransition badBlock11Right = new TranslateTransition(Duration.millis(1000), badBlock11);
		badBlock11Right.setByX(840);
		TranslateTransition badBlock11Left = new TranslateTransition(Duration.millis(3500), badBlock11);
		badBlock11Left.setByX(-840);
		badBlock11Transition.getChildren().addAll(badBlock11Left, badBlock11Down, badBlock11Right, badBlock11Up);
		
		//BAD BLOCK 12 TRANSITION
		TranslateTransition badBlock12Up = new TranslateTransition(Duration.millis(100), badBlock12);
		badBlock12Up.setByY(-180);
		TranslateTransition badBlock12Down = new TranslateTransition(Duration.millis(100), badBlock12);
		badBlock12Down.setToY(0);
		TranslateTransition badBlock12Right = new TranslateTransition(Duration.millis(1000), badBlock12);
		badBlock12Right.setByX(840);
		TranslateTransition badBlock12Left = new TranslateTransition(Duration.millis(3500), badBlock12);
		badBlock12Left.setByX(-840);
		badBlock12Transition.getChildren().addAll(badBlock12Left, badBlock12Up, badBlock12Right, badBlock12Down);
		badBlock13Transition.getChildren().addAll(badBlock11Transition, badBlock12Transition);
		
		//BAD BLOCK 2 TRANSITION
		TranslateTransition badBlock2Up = new TranslateTransition(Duration.millis(100), badBlock2);
		badBlock2Up.setToY(0);
		TranslateTransition badBlock2Down = new TranslateTransition(Duration.millis(100), badBlock2);
		badBlock2Down.setByY(300);
		TranslateTransition badBlock2Right = new TranslateTransition(Duration.millis(1000), badBlock2);
		badBlock2Right.setToX(0);
		TranslateTransition badBlock2Left = new TranslateTransition(Duration.millis(3000), badBlock2);
		badBlock2Left.setByX(-840);
		badBlock2Transition.getChildren().addAll(badBlock2Left, badBlock2Down, badBlock2Right, badBlock2Up);
		
		//BAD BLOCK 3 TRANSITION
		TranslateTransition badBlock3Up = new TranslateTransition(Duration.millis(100), badBlock3);
		badBlock3Up.setByY(-300);
		TranslateTransition badBlock3Down = new TranslateTransition(Duration.millis(100), badBlock3);
		badBlock3Down.setToY(0);
		TranslateTransition badBlock3Right = new TranslateTransition(Duration.millis(1000), badBlock3);
		badBlock3Right.setToX(0);
		TranslateTransition badBlock3Left = new TranslateTransition(Duration.millis(3000), badBlock3);
		badBlock3Left.setByX(-840);
		badBlock3Transition.getChildren().addAll(badBlock3Left, badBlock3Up, badBlock3Right, badBlock3Down);
		
		//BAD BLOCK 4 TRANSITION
		TranslateTransition badBlock4Up = new TranslateTransition(Duration.millis(100), badBlock4);
		badBlock4Up.setToY(0);
		TranslateTransition badBlock4Down = new TranslateTransition(Duration.millis(100), badBlock4);
		badBlock4Down.setByY(300);
		TranslateTransition badBlock4Right = new TranslateTransition(Duration.millis(1000), badBlock4);
		badBlock4Right.setToX(0);
		TranslateTransition badBlock4Left1 = new TranslateTransition(Duration.millis(3000), badBlock4);
		badBlock4Left1.setByX(-400);
		TranslateTransition badBlock4Left2 = new TranslateTransition(Duration.millis(3000), badBlock4);
		badBlock4Left2.setByX(-440);
		TranslateTransition badBlock4Switch = new TranslateTransition(Duration.millis(300), badBlock4);
		badBlock4Switch.setByY(75);
		badBlock4Transition.getChildren().addAll(badBlock4Left1, badBlock4Switch, badBlock4Left2, badBlock4Down, badBlock4Right, badBlock4Up);
		
		//BAD BLOCK 51 TRANSITION
		TranslateTransition badBlock51Up = new TranslateTransition(Duration.millis(100), badBlock51);
		badBlock51Up.setToY(0);
		TranslateTransition badBlock51Down = new TranslateTransition(Duration.millis(100), badBlock51);
		badBlock51Down.setToY(180);
		TranslateTransition badBlock51Right = new TranslateTransition(Duration.millis(1000), badBlock51);
		badBlock51Right.setByX(840);
		TranslateTransition badBlock51Left = new TranslateTransition(Duration.millis(2000), badBlock51);
		badBlock51Left.setByX(-840);
		badBlock51Transition.getChildren().addAll(badBlock51Left, badBlock51Down, badBlock51Right, badBlock51Up);
		
		//BAD BLOCK 52 TRANSITION
		TranslateTransition badBlock52Up = new TranslateTransition(Duration.millis(100), badBlock52);
		badBlock52Up.setByY(-180);
		TranslateTransition badBlock52Down = new TranslateTransition(Duration.millis(100), badBlock52);
		badBlock52Down.setToY(0);
		TranslateTransition badBlock52Right = new TranslateTransition(Duration.millis(1000), badBlock52);
		badBlock52Right.setByX(840);
		TranslateTransition badBlock52Left = new TranslateTransition(Duration.millis(2000), badBlock52);
		badBlock52Left.setByX(-840);
		badBlock52Transition.getChildren().addAll(badBlock52Left, badBlock52Up, badBlock52Right, badBlock52Down);
		badBlock53Transition.getChildren().addAll(badBlock51Transition, badBlock52Transition);
		
		//TIMES AND PLAYS THE TRANSITIONS
		BB13timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (!hit)
	                badBlock13Transition.play();
	            });
			 }
	    }, 0l, 8300l);
		
		BB2timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (!hit)
	                badBlock2Transition.play();
	            });
			 }
	    }, 1400l, 8300l);
		
		BB3timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (!hit)
	                badBlock3Transition.play();
	            });
			 }
	    }, 2800l, 8300l);
		
		BB4timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (!hit)
	                badBlock4Transition.play();
	            });
			 }
	    }, 4200l, 8300l);
		
		BB53timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (!hit) {
	            		if (random.nextBoolean())
	            		badBlock53Transition.play();
	            	}
	            });
			 }
	    }, 5500l, 8300l);
	}
	
	//CAN'T MOVE TWICE AT ONCE
	private void moveTimer()
	{
		TimerTask task = new TimerTask()
		{
			public void run()
			{
				canMove = true;
			}
		};
		timer.schedule(task, 200l);
	}
		
	//CHECKS FOR COLLISIONS
	private void checkCollisions() throws Exception
	{
			collisionTimer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					Platform.runLater(() -> {
						if (!hit) {
							Shape intersectBB11 = Shape.intersect(rectangleMan, badBlock11);
							if (intersectBB11.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							Shape intersectBB12 = Shape.intersect(rectangleMan, badBlock12);
							if (intersectBB12.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							Shape intersectBB2 = Shape.intersect(rectangleMan, badBlock2);
							if (intersectBB2.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							Shape intersectBB3 = Shape.intersect(rectangleMan, badBlock3);
							if (intersectBB3.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							Shape intersectBB4 = Shape.intersect(rectangleMan, badBlock4);
							if (intersectBB4.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							Shape intersectBB51 = Shape.intersect(rectangleMan, badBlock51);
							if (intersectBB51.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							Shape intersectBB52 = Shape.intersect(rectangleMan, badBlock52);
							if (intersectBB52.getBoundsInParent().getWidth() > 0) {
								hit = true;
								try {
									stopGame();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					});
				}
			}, 0l, 50l);
	}
	
	//STOPS GAME
	private void stopGame() throws Exception {
		badBlock13Transition.stop();
		badBlock2Transition.stop();
		badBlock3Transition.stop();
		badBlock4Transition.stop();
		badBlock53Transition.stop();
		canExit = true;
		labelEnd.setLayoutY(0);
		rectangleManMain.stop();
		rectangleManMain.setScore(score);
		rectangleManMain.setGameToDone();
	}

	@FXML
	public void exitApplication() {
		Platform.exit();
	}
	
	//KEEPS SCORE
	private void scoreKeeper()
	{
		scoreTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (!hit)
	                	score +=10;
	            		labelScore.setText("Score: " + score);
	            });
			 }
	    }, 0l, 193l);
	}
	
	@FXML
	private void handleButtonPress(ActionEvent event) 
	{
		
	}
	
	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception
	{

		if (e.getCode() == KeyCode.ENTER && canExit)
		{
			rectangleManMain.stop();
		}
		if (e.getCode() == KeyCode.ENTER && !gameStarted)
		{
			labelStart.setVisible(false);
			gameStarted = true;
			runEnemies();
			try {
				checkCollisions();
			}
			catch (Exception x){}
			scoreKeeper();
		}
		
		else if (e.getCode() == KeyCode.W && up && position < TOP && canMove)
		{
			canMove = false;
			position++;
			jump();
			moveTimer();
		}
		
		else if (e.getCode() == KeyCode.S && up && position > BOTTOM && canMove)
		{
			canMove = false;
			position--;
			land();
			moveTimer();
		}
		else if (e.getCode() == KeyCode.A)
		{
			up = false;
			layDown();
		}
		if (hit) 
		{

		}
	}
	
	@FXML
	private void handleKeyRelease(KeyEvent e) throws Exception
	{
		switch(e.getCode())
		{
		case A:
			up = true;
			standUp();
		default:
			break;
		}
		if (hit)
		{
			
		}
	}

	public void initData(RectangleManMain rectangleManMain) {
		this.rectangleManMain = rectangleManMain;
	}
}
