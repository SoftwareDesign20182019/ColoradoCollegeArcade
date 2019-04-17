package Package;

/**
 * 
 * Class for the factory that switches to the user-selected game
 */
public class GameFactory {

	/**
	 * Factory that returns a new instance of a game base on user selection
	 * @param userChoice - the game that the user selected
	 * @return Game - the game to be played
	 * @throws Exception
	 */
	public Game selectGame(int userChoice) throws Exception {
        switch (userChoice) {
            case Arcade.JAVELIN_THROW:
            	JavelinThrow javelinGame = new JavelinThrow();
                return javelinGame;
            case Arcade.RECTANGLE_MAN:
                RectangleMan rectangleManMain = new RectangleMan();
                return rectangleManMain;
            case Arcade.SUPER_VACUUM:
            	SuperVacuum superVacuum = new SuperVacuum();
            	return superVacuum;
            case Arcade.CLICKER_GAME:
            	//ClickerIdle clickerIdle = new ClickerIdle(); currently in development, ignore!
            	//return clickerIdle;
            	return null;
            case Arcade.FISHERMAN:
            	FishermanMain fisherman = new FishermanMain();
            	return fisherman;
            default:
                return null;
        }
    }
}