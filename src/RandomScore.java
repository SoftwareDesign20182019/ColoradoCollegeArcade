public class RandomScore implements Game {

    public int playGame(){
        return scoreGame();
    }

    private int scoreGame(){
        return (int) (Math.random() * 10);
    }
}
