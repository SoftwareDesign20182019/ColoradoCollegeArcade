
public class Arcade {
	
	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	
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
    }
	
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
		playGame(arcade);
	}

}
