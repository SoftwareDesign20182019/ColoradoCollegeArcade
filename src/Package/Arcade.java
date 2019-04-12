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
	
	public void runNewGame(int choice) throws Exception {
		GameFactory factory = new GameFactory();
		game = factory.selectGame(choice);
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
