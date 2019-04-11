
public class Arcade {
	
	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	private Game game;
	
	public Arcade() {
		menu = new ArcadeMenu();
		controller = new MenuController(menu, this);
		factory = new GameFactory();
		database = new ScoreDatabase("HighScores");
	}
	
	private void updateDatabase(String gameName, String name, int score) {
		database.addScore(gameName, name, score);
	}
	
	public void startNewGame(int choice) {
    	game = factory.selectGame(choice);
    	game.playGame();
	}
	
	private void showMenu() {
    	String[] args = {};
    	menu.main(args);
	}
	
	/*
    private void playGame(Arcade arcade) {
    	arcade.showMenu();
    }
    */
	
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
		arcade.showMenu();
	}

}
