
public class Arcade {

    private static String driverName = "com.mysql.jdbc.Driver";
    private ScoreDatabase database;
    private Game game;
    //	private ArcadeMenu menu;
//	private MenuController controller;
	private GameFactory factory;
	
	public Arcade() {
//		menu = new ArcadeMenu();
//		controller = new MenuController(menu, this);
		factory = new GameFactory();
        database = new ScoreDatabase();
	}
	
	public static void main(String[] args) {
        Arcade arcade = new Arcade(); //we can't create a connection with the database from outside of the class?
//		arcade.showMenu();
        Game game = new RandomScore();
        System.out.println(game.playGame());
        int score = game.playGame();
        try {
            Class.forName(driverName);
            arcade.updateDatabase(game.toString(), "ASS", score);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found.");
        }
    }

    public void startNewGame(int choice) {
        game = factory.selectGame(choice);
        game.playGame();
    }

//	private void showMenu() {
//    	String[] args = {};
//    	menu.main(args);
//	}
	
	/*
    private void playGame(Arcade arcade) {
    	arcade.showMenu();
    }
    */

    private void updateDatabase(String gameName, String name, int score) {
        database.createConnection("ArcadeGames");
        database.createTable(gameName);
        database.addScore(gameName, name, score);
    }

}
