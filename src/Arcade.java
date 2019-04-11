
public class Arcade {
	
	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	private Game game;
	
	public Arcade() {
		menu = new ArcadeMenu();
		controller = new MenuController();
		factory = new GameFactory();
		database = new ScoreDatabase("High Scores");
	}
	
	private void updateDatabase(String gameName, String name, int score) {
		database.addScore(gameName, name, score);
	}
	
	private void showMenu() {
    	String[] args = {};
    	menu.main(args);
	}

    private void playGame(Arcade arcade) {
    	arcade.showMenu();
    	game = factory.selectGame(userChoice);
    	game.playGame();
    }
	
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
		playGame(arcade);
	}

}
