/**
 * Class for the factory that switches to the user-selected game
 */
public class GameFactory {

    public Game selectGame(int userChoice) {
        switch (userChoice) {
            case 1:
                return new RandomScore();
            default:
                return null;
        }
    }
}