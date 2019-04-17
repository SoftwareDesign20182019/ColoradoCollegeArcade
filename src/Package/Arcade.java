package Package;

import javafx.stage.Stage;
import java.util.HashMap;

/**
 * main class for operating the arcade
 * handles database interactions, the creation of games,
 * and the playing of games
 *
 */
public class Arcade {


	@SuppressWarnings("unused")
	private ArcadeMenu menu;
	@SuppressWarnings("unused")
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	private Game game;
    private HashMap<String, String> topTenScores;
    private int highScore;
    private NameSelector nameSelector;
    private HighScore highScoreScreen;
    @SuppressWarnings("unused")
	private Stage gameStage;
    private String gameName;
    
    public static final int JAVELIN_THROW = 1;
    public static final int RECTANGLE_MAN = 2;
    public static final int SUPER_VACUUM = 3;
    public static final int SOFTWARE_TYCOON = 4;



	/**
	 * simple constructor for the arcade,
	 * creates a new game factory, a database for storing scores, and a hashmap for the top ten scores
	 */
    public Arcade() {
		factory = new GameFactory();
		database = new ScoreDatabase("ArcadeGames");
        topTenScores = new HashMap<>();
    }

    /**
     * Main method to begin the game
     * Opens a new menu
     * @param args
     */
    public static void main(String[] args) {
        Arcade arcade = new Arcade();
        arcade.createMenu();
        arcade.showMenu();
    }

	/**
	 * Calls the factory to create a new game based on the game selected in the menu
	 * @param choice integer choice selected from the menu
     * @throws Exception
	 */
	public void runNewGame(int choice) throws Exception {
        Stage gameStage = new Stage();
        game = factory.selectGame(choice);
        if (game != null) {
            game.playGame(gameStage, this);
        }
    }

	/**
	 * Method called if the user chooses to play the same game
	 * game is saved as an attribute so the same game can just be played again on a new stage
	 * @throws Exception
	 */
	public void playAgain() throws Exception {
		Stage gameStage = new Stage();
		game.playGame(gameStage, this);
	}
	
	/**
	 * Method called when the game ends to open new stage for name selector
	 * @param score - passed back from the game
	 * @throws Exception
	 */
    public void endGameToNameChoice(int score) throws Exception {
        highScore = score;
        Stage nameStage = new Stage();
        nameSelector = new NameSelector();
        nameSelector.openNameSelector(nameStage, this);
    }

    /**
     * Adds the new score to the database and opens a new stage for the high score screen
     * @param name - the user selected name
     * @throws Exception
     */
    public void displayHighScores(String name) throws Exception {
	    gameName = game.toString();
	    database.createTable(gameName);
        database.addScore(gameName, name, highScore);
        Stage stage = new Stage();
        highScoreScreen = new HighScore();
        highScoreScreen.displayHighScores(stage, this);
    }

    /**
     * Returns the top ten high scores from the database
     * Effectively used by the HighScoreController to get scores
     * @return - the hashmap of the top ten scores (with scores as a String)
     */
    public HashMap<String, String> getHighScores() {
        topTenScores = database.getScores(gameName);
        return topTenScores;
    }

    /**
     * Returns the game name
     * Used by HighScore which returns the gameName to the HighScoreController
     * @return - the game's name
     */
    public String getGameName(){
	    return game.getGameName();
    }

    /**
	 * Starts the arcade menu application
	 */
	private void showMenu() {
        String[] args = {};
		ArcadeMenu.main(args);
	}

    /**
	 * Creates a new arcade menu application
	 */
	private void createMenu() {
		menu = new ArcadeMenu();
	}
	
	/**
	 * sets the score for testing purposes
	 * @param score the score to set
	 */
	public void setScore(int score) {
		highScore = score;
	}
	
	/**
	 * gets the high score for testing purposes
	 * @return the high score
	 */
	public int getScore() {
		return highScore;
	}

}
