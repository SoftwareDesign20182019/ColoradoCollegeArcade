package Package;



import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class ClickerController extends TimerTask implements Initializable {


	private ClickerIdle game;
	private int dollars;
	
	private double codeProgress;
	private double codeRate = 0;
	private double juniorDevPrice = 10;
	
	private int juniorDevs = 0;
	
	private static final int LINES_TO_COMMIT = 150;
	
	
	Timer timer = new Timer();
	//ProgressBar linesComplete = new ProgressBar(); 
	
	
	
	@FXML
	Label currentCash;

	@FXML
	Label juniorDevPriceLabel;
	

	@FXML
	ProgressBar linesComplete;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//this runs when the game is opened
		playGame();
	}

	public void initData(ClickerIdle game) {
		this.game = game;
	}

	private void returnScore() throws Exception {
		game.setScore(0);
		game.setGameToDone();
	}

	//runs the game
	private void playGame() {
		System.out.println("yeet");
		//updateDollars();
		startUpdating();
	}



	//method that refreshes every 10th of a second
	public void startUpdating()
	{
		TimerTask task = new TimerTask()
		{
			public void run(){
				Platform.runLater(() -> {
					refreshUpdate();
				});
			}
		};
		timer.schedule(task, 100l);
	}

	
	public void refreshUpdate()
	{
		updateProgressBar();
		updateCashLabel();
		startUpdating();
	}
	
	public void updateCashLabel()
	{
		currentCash.setText("Money: " + dollars);
	}
	
	public void updateProgressBar() 
	{
		codeProgress += codeRate / LINES_TO_COMMIT;
		linesComplete.setProgress(codeProgress);
		
		if(codeProgress >= 1)
		{
			convertCodeToMoney();
		}
	}

	private void convertCodeToMoney()
	{
		dollars++;
		codeProgress = 0;
	}

	public void run(){}

	private void updateDollars() {

	}

	@FXML
	public void writeCode(ActionEvent event)
	{
		codeProgress += 0.25;
	}
	
	@FXML
	public void hireDeveloper(ActionEvent event)
	{
		if(dollars < juniorDevPrice)
		{
			return;
		}
		dollars -= juniorDevPrice;
		juniorDevPrice = (int) juniorDevPrice * 1.1;
		juniorDevs++;
		
		juniorDevPriceLabel.setText("Cost: " + juniorDevPrice);
		codeRate += .5;
	}
	
	

	@FXML
	private void handleKeyPress(KeyEvent e) throws Exception
	{
		System.out.println("you pressed a key");
	}
}