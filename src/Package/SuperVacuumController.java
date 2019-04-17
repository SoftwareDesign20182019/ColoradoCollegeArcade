package Package;


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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Controller for the Super Vacuum Stage
 * @author ellaneurohr
 *
 */
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
	Text endText;
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
	
	Thread t;

	private boolean movingLeft = false;
	private boolean movingRight= false;
	private boolean gameStarted = false;
	private boolean canReachLeft = true;
	private boolean canReachRight = true;
	private boolean canReach = false;
	private boolean loseLife = true;
	private boolean gameEnded = false;
	private SuperVacuum superVacuumMain;
	private int instruction = 1;

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

	/**
	 * Moves all super vacuum images and the hit box left
	 */
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

	/**
	 * Moves all super vacuum images and the hit box right
	 */
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

	/**
	 * Villain 1
	 */
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
	
	/**
	 * Villain 1 timer
	 */
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

	/**
	 * Villain 2
	 */
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
	
	/**
	 * Villain 2 timer
	 */
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

	/**
	 * Trash 1
	 */
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
	
	/**
	 * Trash 1 timer
	 */
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
		try {
			timer.schedule(trash1Task, 6000l-(pace+52));
		} catch (Exception e){} //doesn't like when the timer ends but isn't actually an error
	}

	/**
	 * Trash 2
	 */
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
	
	/**
	 * Trash 2 Timer
	 */
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
//						labelLives.setText("Lives: "+lives);
						endGame();
					}
				}
				loseLife = true;
				trash2.setVisible(true);
				trash2Actions();
			}
		};
		timer.schedule(trash2Task, 6000l-(pace+52));
	}

	/**
	 * Repeatedly called to update game score
	 */
	public void scoreGame()
	{
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					score += 100;
					if(lives >= 0 )
					{
						labelLives.setText("Lives: "+lives);
					}
					if(lives > 0)
					{
						labelScore.setText("Score: "+score);
					}
				});
			}
		}, 3000l, 3000l);
	}

	/**
	 * Calls up end game text
	 */
	public void endGame()
	{
		//		timer.cancel(); // I feel like we don't need this but I'm not will so I''m not gonna delete it yet
		canReach = false;
		startText.setText("Game Over!");
		endText.setText("You Scored: " + score + " Points. Press Enter to Continue.");
		endText.setVisible(true);
		startText.setVisible(true);
		labelLives.setVisible(true);
		gameEnded = true;
	}

	/**
	 * Plays the game
	 */
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

	/**
	 * Collision timer
	 */
	public void collisionTimer() {
		TimerTask task = new TimerTask() {
			public void run()
			{
				checkCollisions();
			}
		};
		timer.schedule(task, 5l);
	}

	/**
	 * Checks collisions
	 */
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

	/**
	 * Button press event necessary for functionality because of weird button bug
	 * @param event - button press
	 */
	@FXML
	private void handleButtonPress(ActionEvent event) 
	{
		System.out.println("I AM WILL");
	}

	/**
	 * Handles key presses and does different actions based on the key pressed and the state
	 * @param e - the key event
	 * @throws Exception 
	 */
	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception
	{
		if (e.getCode() == KeyCode.ENTER && gameEnded)
		{
			superVacuumMain.setScore(score);
			superVacuumMain.setGameToDone();
		}
		if (e.getCode() == KeyCode.ENTER && !gameStarted && instruction == 1)
		{
			startText.setText("Use A and D to move back and forth and J and L to extend your vacuum arm (Press Enter to Start)");
			instruction++;
		}
		if (e.getCode() == KeyCode.ENTER && !gameStarted && instruction == 2)
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

	/**
	 * Handles key releases and does different actions based on the key released and the state
	 * @param e - the key event
	 * @throws Exception 
	 */
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

	/**
	 * Allows the main SuperVacuum class to be passed in to this controller
	 * Necessary for backwards retrieval of data
	 * @param highScore - the instance of the SuperVacuum class
	 */
	public void initData(SuperVacuum superVacuumMain) {
		this.superVacuumMain = superVacuumMain;
	}

}
