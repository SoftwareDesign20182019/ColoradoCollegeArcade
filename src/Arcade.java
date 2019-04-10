
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

    private void playGame() {

    }
	
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
	}

}
