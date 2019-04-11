package Package;

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
	
	/**
	 * simple constructor for the arcade,
	 * creates a new game factory and database for storing scores
	 */
	public Arcade() {
		factory = new GameFactory();
		database = new ScoreDatabase("ArcadeGames");
	}
	
	/**
	 * takes the choice picked from the game menu and
	 * creates a corresponding game to be played
	 * then saves the high score, player, and game to the database
	 * @param choice integer choice for the game to play
	 * @return the string representation of each game
	 */
	public String runNewGame(int choice) {
		int highScore;
		String playerName;
		String gameName;
		
    	Game game = factory.selectGame(choice);
    	if (game != null) {
        	highScore = game.playGame();
        	playerName = game.getName();
        	gameName = game.toString();
        	database.addScore(gameName, playerName, highScore);
    	}
    	else {
        	gameName = null;	
    	}
    	return gameName;
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
	
	/**
	 * main method for the class -
	 * creates an instance of this class for calling other methods
	 * @param args
	 */
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
		arcade.createMenu();
		arcade.showMenu();
	}

}
