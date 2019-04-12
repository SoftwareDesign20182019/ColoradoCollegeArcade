package Package;

import java.util.HashMap;

public class Arcade {
	
	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	private Game game;
    private HashMap<String, String> topTenScores;

	public Arcade() {
		factory = new GameFactory();
		database = new ScoreDatabase("ArcadeGames");
        topTenScores = new HashMap<>();
	}
	
	/*
	private void updateDatabase(String gameName, String name, int score) {
		database.addScore(gameName, name, score);
	}
	*/
	
	public void runNewGame(int choice) {
    	Game game = factory.selectGame(choice);
    	int highScore = game.playGame();
    	String playerName = game.getName();
    	String gameName = game.toString();
        database.addScore(gameName, playerName, Integer.toString(highScore));
        topTenScores = database.getScores(game.toString());
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
