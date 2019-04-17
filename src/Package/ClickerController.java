package Package;

import java.math.BigDecimal;

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

/**
 * Controller for the Clicker FXML file
 * @author dhardwick
 *
 */
public class ClickerController extends TimerTask implements Initializable {


	private ClickerIdle game;
	
	private int dollars;
	private int score;
	private int timeLeft = 300;
	private int cyclesLeftInSecond = 100;
	
	
	
	//Statistics Related to Hiring//
	
	private double codeProgress;
	private double codeRate = 0;
	
	private double juniorDevPrice = 10;
	private double juniorDeveloperSpeed = .1;
	int juniorDevelopers = 0;
	
	private double softwareDeveloperPrice = 50;
	private double softwareDeveloperSpeed = .15;
	int softwareDevelopers = 0;
	
	private double designArchitectPrice = 250;
	int architectModifier = 0;
	int designArchitects = 0;
	
	private double technicalLeadPrice = 1000;
	private double technicalLeadSpeed = .3;
	int technicalLeads = 0;
	
	private double tenXDeveloperPrice = 7500;
	private double tenXDeveloperSpeed = 1;
	int tenXDevelopers = 0;

	private double theScrumMasterPrice = 30000;
	private double theScrumMasterSpeed = 2;
	int theScrumMasters = 0;
	
	private static final int LINES_TO_COMMIT = 500;
	
	
	Timer timer = new Timer();
	
	
	//status labels
	@FXML
	Label currentCash;

	@FXML
	Label currentCodeProgress;
	
	@FXML
	ProgressBar linesComplete;
	
	@FXML
	Label currentScore;
	
	@FXML
	Label timeRemaining;
	
	
	//staff labels
	@FXML
	Label juniorDevPriceLabel;
	
	@FXML
	Label softwareDeveloperPriceLabel;

	@FXML
	Label designArchitectPriceLabel;
	
	@FXML
	Label technicalLeadPriceLabel;
	
	@FXML
	Label tenXDeveloperPriceLabel;
	
	@FXML
	Label theScrumMasterPriceLabel;
	
	/**
	 * Runs at the start of the game, and starts 
	 * the loop which runs every frame
	 * @param Location the location of the FXML
	 * @param ResourceBundle the resources for the root object
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		startUpdating();
	}

	public void initData(ClickerIdle game) {
		this.game = game;
	}

	@SuppressWarnings("unused")
	private void returnScore() throws Exception {
		game.setScore(score);
		game.setGameToDone();
	}


	/**
	 * Starts the loop of methods which runs every 100th of a second,
	 * updating the screen
	 */
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
		timer.schedule(task, 10l);
	}

	/**
	 * Continues the loop, updating the GUI and returning to the previous
	 * method to wait until the next refresh
	 */
	public void refreshUpdate()
	{
		if(timeLeft == 0)
		{
			System.out.println("Time is up!"); //ELLA, just kick the player to the "enter name screen"
		}
		if(secondPassed())
		{
			timeLeft--;
		}
		updateProgressBar();
		updateStatusLabels();
		startUpdating();
	}
	
	/**
	 * Updates the labels associated with progression
	 * (Money, Score, Time Remaining and Commit Progress)
	 */
	public void updateStatusLabels()
	{
		currentCash.setText("Money: " + dollars);
		currentScore.setText("Score: " + score);
		currentCodeProgress.setText("Code Progress: " + truncateDecimal((codeProgress*100), 0) + "%");
		timeRemaining.setText("Time Remaining: " + timeLeft);
	}
	
	/**
	 * Checks to see if a second has passed (100 cycles)
	 * @return true if a second has passed - otherwise false
	 */
	private boolean secondPassed()
	{
		cyclesLeftInSecond--;
		if(cyclesLeftInSecond == 0)
		{
			cyclesLeftInSecond = 100;
			return true;
		}
		return false;
	}
	
	/**
	 * Truncates a double to a desired number of decimals (rounding down)
	 * @param x the number being truncated
	 * @param numberofDecimals the number of desired decimal places
	 * @return
	 */
	private static BigDecimal truncateDecimal(double x,int numberofDecimals)
	{
	    if ( x > 0) {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
	    } else {
	        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
	    }
	}

	
	/**
	 * Updates the progression bar, pushes a commit if the bar is full
	 */
	private void updateProgressBar() 
	{
		codeProgress += codeRate / LINES_TO_COMMIT;
		linesComplete.setProgress(codeProgress);
		
		if(codeProgress >= 1)
		{
			pushCommit();
		}
	}

	
	/**
	 * Adds money and score, resets the code progression
	 */
	private void pushCommit()
	{
		dollars += (10 + architectModifier);
		score += (10 + architectModifier);
		codeProgress = 0;
	}

	/**
	 * Makes code progress increase on button press
	 * @param event user clicked on "Write Code"
	 */
	@FXML
	public void writeCode(ActionEvent event)
	{
		codeProgress += 0.25;
	}
	
	/**
	 * Hires a junior developer, assuming enough money, recalculates code speed and updates labels
	 * @param event user clicked on "Hire Junior Developer"
	 */
	@FXML
	public void hireJuniorDeveloper(ActionEvent event)
	{
		if(dollars < juniorDevPrice)
		{
			return;
		}
		dollars -= juniorDevPrice;
		juniorDevPrice = (int) juniorDevPrice * 1.5;
		juniorDevelopers++;
		
		codeRate += juniorDeveloperSpeed;
		
		juniorDevPriceLabel.setText("Have " + juniorDevelopers + ", making " + 
			truncateDecimal(juniorDevelopers* juniorDeveloperSpeed, 2) + " lines per second - Price: $" + 
			truncateDecimal(juniorDevPrice, 1));
	}
	
	/**
	 * Hires a software developer, assuming enough money, recalculates code speed and updates labels
	 * @param event user clicked on "Hire Software Developer"
	 */
	@FXML
	public void hireSoftwareDeveloper(ActionEvent event)
	{
		if(dollars < softwareDeveloperPrice)
		{
			return;
		}
		dollars -= softwareDeveloperPrice;
		softwareDeveloperPrice = (int) softwareDeveloperPrice * 1.5;
		softwareDevelopers++;
		
		codeRate += juniorDeveloperSpeed;
		
		softwareDeveloperPriceLabel.setText("Have " + softwareDevelopers + ", making " + 
				truncateDecimal(softwareDevelopers* softwareDeveloperSpeed, 2) + " lines per second - Price: $" + 
				truncateDecimal(softwareDeveloperPrice, 1));
	}
	
	/**
	 * Hires a design architect, assuming enough money, recalculates commit value and updates labels
	 * @param event user clicked on "Hire Design Architect"
	 */
	@FXML
	public void hireDesignArchitect(ActionEvent event)
	{
		if(dollars < designArchitectPrice)
		{
			return;
		}
		dollars -= designArchitectPrice;
		designArchitectPrice = (int) designArchitectPrice * 1.5;
		designArchitects++;
		
		architectModifier += 1;
		
		designArchitectPriceLabel.setText("Have " + designArchitects + ", increasing commit value by " + 
				architectModifier + " - Price: $" + 
				truncateDecimal(designArchitectPrice, 1));
	}
	
	/**
	 * Hires a technical lead, assuming enough money, recalculates code speed and updates labels
	 * @param event user clicked on "Hire Technical Lead"
	 */
	@FXML
	public void hireTechnicalLead(ActionEvent event)
	{
		if(dollars < technicalLeadPrice)
		{
			return;
		}
		dollars -= technicalLeadPrice;
		technicalLeadPrice = (int) technicalLeadPrice * 1.5;
		technicalLeads++;
		
		codeRate += technicalLeadSpeed;
		
		technicalLeadPriceLabel.setText("Have " + technicalLeads + ", making " + 
				truncateDecimal(technicalLeads* technicalLeadSpeed, 2) + " lines per second - Price: $" + 
				truncateDecimal(technicalLeadPrice, 1));
	}
	
	/**
	 * Hires a 10x Developer, assuming enough money, recalculates code speed and updates labels
	 * @param event user clicked on "Hire 10x Developer"
	 */
	@FXML
	public void hireTenXDeveloper(ActionEvent event)
	{
		if(dollars < tenXDeveloperPrice)
		{
			return;
		}
		dollars -= tenXDeveloperPrice;
		tenXDeveloperPrice = (int) tenXDeveloperPrice * 1.5;
		tenXDevelopers++;
		
		codeRate += tenXDeveloperSpeed;
		
		tenXDeveloperPriceLabel.setText("Have " + tenXDevelopers + ", making " + 
				truncateDecimal(tenXDevelopers* tenXDeveloperSpeed, 2) + " lines per second - Price: $" + 
				truncateDecimal(tenXDeveloperPrice, 1));
	}
	
	/**
	 * Hires the Scrum Master, assuming enough money, recalculates code speed and updates labels
	 * @param event user clicked on "Hire Scrum Master"
	 */
	@FXML
	public void hireTheScrumMaster(ActionEvent event)
	{
		if(dollars < theScrumMasterPrice)
		{
			return;
		}
		dollars -= theScrumMasterPrice;
		theScrumMasterPrice = (int) theScrumMasterPrice * 1.5;
		theScrumMasters++;
		
		codeRate += theScrumMasterSpeed;
		
		tenXDeveloperPriceLabel.setText("Have " + theScrumMasters + ", making " + 
				truncateDecimal(theScrumMasters* theScrumMasterSpeed, 2) + " lines per second - Price: $" + 
				truncateDecimal(theScrumMasterPrice, 1));
	}
	
	/**
	 * Junk method, needed for the TimerTask utility
	 */
	public void run(){}
}