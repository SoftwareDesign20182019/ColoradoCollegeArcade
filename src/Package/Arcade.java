package Package;

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
	private ApplicationFactory factory;
	private ScoreDatabase database;
	private Game game;
    private HashMap<String, String> topTenScores;

	/**
	 * simple constructor for the arcade,
	 * creates a new game factory and database for storing scores
	 */
    public Arcade() {
		factory = new ApplicationFactory();
		database = new ScoreDatabase("ArcadeGames");
        topTenScores = new HashMap<>();
	}
	
	/**
	 * takes the choice picked from the game menu and
	 * creates a corresponding game to be played
	 * then saves the high score, player, and game to the database
	 * @param choice integer choice for the game to play
	 * @return the string representation of each game
	 * @throws Exception 
	 */
	public String runNewApplication(int choice) throws Exception {
		int highScore = 0;
		String playerName;
		String gameName;
		
    	Game game = factory.selectGame(choice);
    	if (game != null) {
    		while(!game.isGameDone()) {
    			highScore = game.getScore();
    		}
    		System.out.println("Game has finished");
        	playerName = game.getName();
        	gameName = game.toString();
            database.addScore(gameName, playerName, Integer.toString(highScore));
            topTenScores = database.getScores(gameName);
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
