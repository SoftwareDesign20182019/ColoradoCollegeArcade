
public class Arcade {
	
	private ArcadeMenu menu;
	private MenuController controller;
	private GameFactory factory;
	private ScoreDatabase database;
	
	public Arcade() {
		menu = new ArcadeMenu();
		controller = new MenuController();
		factory = new GameFactory();
		database = new ScoreDatabase();
	}
	
	public static void main(String[] args) {
		Arcade arcade = new Arcade();
	}

}
