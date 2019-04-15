package Package;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Bounds;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SuperVacuumController{
	@FXML
	ImageView superVacuum;
	@FXML
	Rectangle hitBox;
	@FXML
	ImageView superVacuumLeft;
	@FXML
	ImageView superVacuumRight;
	@FXML
	Text startText;
	@FXML
	ImageView villain1;
	@FXML
	ImageView villain2;
	@FXML
	Circle trash1;
	@FXML
	Circle trash2;
	@FXML
	Rectangle ground;
	@FXML
	Label labelScore;
	@FXML
	Label labelLives;
	@FXML
	Label labelLives0;
	
	private boolean movingLeft = false;
	private boolean movingRight= false;
	private boolean gameStarted = false;
	private boolean canReachLeft = true;
	private boolean canReachRight = true;
	private boolean canReach = false;
	private boolean loseLife = true;
	private boolean gameEnded = false;
	
	Timer timer = new Timer();
	Timer reachTimer = new Timer();
	
	long pace = 0;
	
	int trash1x;
	int trash2x;
	int lives = 3;
	int score = 0;
	
	SequentialTransition trash1Move;
	SequentialTransition trash1Reset;
	SequentialTransition trash2Move;
	SequentialTransition trash2Reset;
	
	//MOVES ALL SUPER VACUUM IMAGES AND THE HIT BOX LEFT
	private void moveLeft()
	{
		TranslateTransition superVacuumMoveLeft = new TranslateTransition(Duration.millis(1), superVacuum);
		superVacuumMoveLeft.setByX(-2);
		TranslateTransition superVacuumLeftLeft = new TranslateTransition(Duration.millis(1), superVacuumLeft);
		superVacuumLeftLeft.setByX(-2);
		TranslateTransition superVacuumRightLeft = new TranslateTransition(Duration.millis(1), superVacuumRight);
		superVacuumRightLeft.setByX(-2);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingLeft && !movingRight)
	            		superVacuumMoveLeft.play();
	            });
			 }
	    }, 0l, 1l);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingLeft && !movingRight)
	            		superVacuumLeftLeft.play();
	            });
			 }
	    }, 0l, 1l);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingLeft && !movingRight)
	            		superVacuumRightLeft.play();
	            });
			 }
	    }, 0l, 1l);
		TranslateTransition hitBoxLeft = new TranslateTransition(Duration.millis(1), hitBox);
		hitBoxLeft.setByX(-2);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingLeft && !movingRight)
	            		hitBoxLeft.play();
	            });
			 }
	    }, 0l, 1l);
	}
	
	//MOVES ALL SUPER VACUUM IMAGES AND THE HIT BOX RIGHT
	private void moveRight()
	{
		TranslateTransition superVacuumMoveRight = new TranslateTransition(Duration.millis(1), superVacuum);
		superVacuumMoveRight.setByX(2);
		TranslateTransition superVacuumLeftRight = new TranslateTransition(Duration.millis(1), superVacuumLeft);
		superVacuumLeftRight.setByX(2);
		TranslateTransition superVacuumRightRight = new TranslateTransition(Duration.millis(1), superVacuumRight);
		superVacuumRightRight.setByX(2);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingRight && !movingLeft)
	            		superVacuumMoveRight.play();
	            });
			 }
	    }, 0l, 1l);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingRight && !movingLeft)
	            		superVacuumLeftRight.play();
	            });
			 }
	    }, 0l, 1l);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingRight && !movingLeft)
	            		superVacuumRightRight.play();
	            });
			 }
	    }, 0l, 1l);
		
		TranslateTransition hitBoxRight = new TranslateTransition(Duration.millis(1), hitBox);
		hitBoxRight.setByX(2);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (movingRight && !movingLeft)
	            		hitBoxRight.play();
	            });
			 }
	    }, 0l, 1l);
	}
	
	//VILLAIN1
	public void villain1Actions()
	{
		SequentialTransition villain1Move = new SequentialTransition();
		TranslateTransition villain1Left = new TranslateTransition(Duration.millis(3000-pace), villain1);
		villain1Left.setByX(-100);
		TranslateTransition villain1Right = new TranslateTransition(Duration.millis(3000-pace), villain1);
		villain1Right.setByX(100);
		villain1Move.getChildren().addAll(villain1Left, villain1Right);
		villain1Move.play();
		villain1Schedule();
	}
	public void villain1Schedule()
	{
		TimerTask villain1Task = new TimerTask() {
			public void run()
			{
				villain1Actions();
			}
		};
		timer.schedule(villain1Task, 6000l-pace);
	}
	
	//VILLAIN2
	public void villain2Actions()
	{
		SequentialTransition villain2Move = new SequentialTransition();
		TranslateTransition villain2Left = new TranslateTransition(Duration.millis(3000-pace), villain2);
		villain2Left.setByX(-100);
		TranslateTransition villain2Right = new TranslateTransition(Duration.millis(3000-pace), villain2);
		villain2Right.setByX(100);
		villain2Move.getChildren().addAll(villain2Right, villain2Left);
		villain2Move.play();
		villain2Schedule();
	}
	public void villain2Schedule()
	{
		TimerTask villain1Task = new TimerTask() {
			public void run()
			{
				villain2Actions();
			}
		};
		timer.schedule(villain1Task, 6000l-pace);
	}
	
	//TRASH 1
	public void trash1Actions()
	{
		Random random = new Random();
		trash1x = random.nextInt(400);
		trash1Move = new SequentialTransition();
		trash1Reset = new SequentialTransition();
		TranslateTransition trash1Right = new TranslateTransition(Duration.millis(3000-pace), trash1);
		trash1Right.setByX(100);
		TranslateTransition trash1Right2 = new TranslateTransition(Duration.millis(100), trash1);
		trash1Right2.setByX(trash1x);
		TranslateTransition trash1Down = new TranslateTransition(Duration.millis(2500-pace), trash1);
		trash1Down.setByY(600);
		TranslateTransition trash1ResetX = new TranslateTransition(Duration.millis(1), trash1);
		trash1ResetX.setByX(-100-trash1x);
		TranslateTransition trash1ResetY = new TranslateTransition(Duration.millis(1), trash1);
		trash1ResetY.setByY(-600);
		trash1Reset.getChildren().addAll(trash1ResetX, trash1ResetY);
		trash1Move.getChildren().addAll(trash1Right, trash1Right2, trash1Down, trash1Reset);
		trash1Move.play();
		trash1Schedule();
	}
	public void trash1Schedule()
	{
		
		TimerTask trash1Task = new TimerTask() {
			public void run()
			{
				if (loseLife)
				{
					lives -= 1;
					if (lives == 0)
					{
						endGame();
					}
				}
				loseLife = true;
				trash1.setVisible(true);
				trash1Actions();
			}
		};
		timer.schedule(trash1Task, 6000l-(pace+52));
	}
	
	//TRASH 2
	public void trash2Actions()
	{
		Random random = new Random();
		trash2x = random.nextInt(400);
		trash2Move = new SequentialTransition();
		trash2Reset = new SequentialTransition();
		TranslateTransition trash2Left = new TranslateTransition(Duration.millis(3000-pace), trash2);
		trash2Left.setByX(-100);
		TranslateTransition trash2Left2 = new TranslateTransition(Duration.millis(100), trash2);
		trash2Left2.setByX(-trash2x);
		TranslateTransition trash2Down = new TranslateTransition(Duration.millis(2500-pace), trash2);
		trash2Down.setByY(600);
		TranslateTransition trash2ResetX = new TranslateTransition(Duration.millis(1), trash2);
		trash2ResetX.setByX(100+trash2x);
		TranslateTransition trash2ResetY = new TranslateTransition(Duration.millis(1), trash2);
		trash2ResetY.setByY(-600);
		trash2Reset.getChildren().addAll(trash2ResetX, trash2ResetY);
		trash2Move.getChildren().addAll(trash2Left, trash2Left2, trash2Down, trash2Reset);
		trash2Move.play();
		trash2Schedule();
	}
	public void trash2Schedule()
	{
		
		TimerTask trash2Task = new TimerTask() {
			public void run()
			{
				if (loseLife)
				{
					lives -= 1;
					if (lives == 0)
					{
						endGame();
					}
					System.out.println("Lives: "+ lives);
				}
				loseLife = true;
				trash2.setVisible(true);
				trash2Actions();
			}
		};
		timer.schedule(trash2Task, 6000l-(pace+52));
	}
	
	//SCORE GAME
	
	public void scoreGame()
	{
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
		            score += 100;
		            labelScore.setText("Score: "+score);
		            labelLives.setText("Lives: "+lives);
	            });
			 }
	    }, 3000l, 3000l);
	}
	
	//END GAME
	public void endGame()
	{
		timer.cancel();
		canReach = false;
		startText.setText("Game Over! You Scored: " + score + " Points. Press Enter to Continue.");
		startText.setVisible(true);
		labelLives.setVisible(false);
		labelLives.setText("Lives: 0");
		labelLives.setVisible(true);
		gameEnded = true;
	}
	
	//PLAY GAME
	public void playGame()
	{
		villain1Actions();
		
		TimerTask startVillain2 = new TimerTask() {
			public void run()
			{
				villain2Actions();
			}
		};
		timer.schedule(startVillain2, 3000l);
		
		TimerTask startTrash1 = new TimerTask() {
			public void run()
			{
				trash1Actions();
			}
		};
		timer.schedule(startTrash1, 3000l);
		
		TimerTask startTrash2 = new TimerTask() {
			public void run()
			{
				trash2Actions();
			}
		};
		timer.schedule(startTrash2, 6000l);
		
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
	        public void run() {
	            Platform.runLater(() -> {
	            	if (pace < 1500)
	            		pace += 100;
	            });
			 }
	    }, 5000l, 5000l);
	}

	public void collisionTimer() {
		TimerTask task = new TimerTask() {
			public void run()
			{
				checkCollisions();
			}
		};
		timer.schedule(task, 5l);
	 }
	
	public void checkCollisions() {
	            	Shape intersectTrash1 = Shape.intersect(hitBox, trash1);
	            	if (intersectTrash1.getBoundsInParent().getWidth() > 0) {
	            		loseLife = false;
	            		trash1.setVisible(false);
	            	}
	            	
	            	Shape intersectTrash2 = Shape.intersect(hitBox, trash2);
	            	if (intersectTrash2.getBoundsInParent().getWidth() > 0) {
	            		loseLife = false;
	            		trash2.setVisible(false);
	            	}
	            	collisionTimer();
	}
	
	@FXML
	private void handleButtonPress(ActionEvent event) 
	{
		System.out.println("I AM WILL");
	}
	
	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception
	{
		if (e.getCode() == KeyCode.ENTER && gameEnded)
		{
			//ELLA THIS IS YOUR SECTION
		}
		if (e.getCode() == KeyCode.ENTER && !gameStarted)
		{
			gameStarted = true;
			canReach = true;
			startText.setVisible(false);
			moveLeft();
			moveRight();
			playGame();
			checkCollisions();
			scoreGame();
		}
		if (e.getCode() == KeyCode.A)
		{
			movingLeft = true;
		}
		if (e.getCode() == KeyCode.D)
		{
			movingRight = true;
		}
		if (e.getCode() == KeyCode.J && canReachLeft && canReach)
		{
			canReachRight = false;
			hitBox.setX(superVacuum.getX()+22);
			superVacuum.toBack();
			superVacuumLeft.toFront();
		}
		if (e.getCode() == KeyCode.L && canReachRight && canReach)
		{
			canReachLeft = false;
			hitBox.setX(superVacuum.getX()+87);
			superVacuum.toBack();
			superVacuumRight.toFront();
		}
	}
	
	@FXML
	private void handleKeyRelease(KeyEvent e) throws Exception
	{
		if (e.getCode() == KeyCode.A)
		{
			movingLeft = false;
		}
		if (e.getCode() == KeyCode.D)
		{
			movingRight = false;
		}
		if (e.getCode() == KeyCode.J && canReachLeft)
		{
			canReachRight = true;
			hitBox.setX(superVacuum.getX()+55);
			superVacuumLeft.toBack();
			superVacuum.toFront();
		}
		if (e.getCode() == KeyCode.L && canReachRight)
		{
			canReachLeft = true;
			hitBox.setX(superVacuum.getX()+55);
			superVacuumRight.toBack();
			superVacuum.toFront();
		}
	}

}
