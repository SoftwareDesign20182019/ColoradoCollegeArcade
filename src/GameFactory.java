/**
 * Class for the factory that switches to the user-selected game
 */
public class GameFactory {

    public Game selectGame(int userChoice) {
        switch (userChoice) {
            case 1:
                RandomScore randomScore = new RandomScore();
                return randomScore;
            default:
                return null;
        }
    }
}