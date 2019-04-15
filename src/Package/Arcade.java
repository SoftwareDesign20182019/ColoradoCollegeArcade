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

	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	private Game game;
    private HashMap<String, String> topTenScores;
    private int highScore;
    private NameSelector nameSelector;
    private HighScore highScoreScreen;
    private Stage gameStage;
    private String gameName;
    
    public static final int JAVELIN_THROW = 1;
    public static final int RECTANGLE_MAN = 2;
    public static final int SUPER_VACUUM = 3;
    public static final int CLICKER_GAME = 4;



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
	 * calls the factory to create a new game based on the game selected in the menu
	 * @param choice integer choice for the game to play
	 * @return the string representation of each game
     * @throws Exception
	 */
	public void runNewGame(int choice) throws Exception {
        Stage gameStage = new Stage();
        game = factory.selectGame(choice);
        if (game != null) {
            game.playGame(gameStage, this);
        }
    }

	public void playAgain() throws Exception {
		Stage gameStage = new Stage();
		game.playGame(gameStage, this);
	}
	
    public void gameUpdate(int score) throws Exception {
        highScore = score;
//        gameStage.hide();
        Stage nameStage = new Stage();
        nameSelector = new NameSelector();
        nameSelector.openNameSelector(nameStage, this);
    }


    public void finishGame(String name) throws Exception {
	    gameName = game.toString();
	    database.createTable(gameName);
        database.addScore(gameName, name, highScore);
//        topTenScores = database.getScores(gameName);
        Stage stage = new Stage();
        highScoreScreen = new HighScore();
        highScoreScreen.displayHighScores(stage, this);

    }

    public HashMap<String, String> getHighScores() {
        topTenScores = database.getScores(gameName);
//        topTenScores = database.
        return topTenScores;
    }

    public String getGameName(){
	    return game.getGameName();
    }

    /**
	 * starts the arcade menu application
	 */
	private void showMenu() {
        String[] args = {};
		ArcadeMenu.main(args);
	}

    /**
	 * creates a new arcade menu application
	 */
	private void createMenu() {
		menu = new ArcadeMenu();
	}

}
