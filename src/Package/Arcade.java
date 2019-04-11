package Package;

public class Arcade {
	
	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	private Game game;
	
	public Arcade() {
		factory = new GameFactory();
		database = new ScoreDatabase("ArcadeGames");
	}
	
	/*
	private void updateDatabase(String gameName, String name, int score) {
		database.addScore(gameName, name, score);
	}
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
	
	private void showMenu() {
    	String[] args = {};
//    	menu.setArcade(this);
		ArcadeMenu.main(args);
	}
	
	private void createMenu() {
		menu = new ArcadeMenu();
	}
			
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
		arcade.createMenu();
		arcade.showMenu();
	}

}
