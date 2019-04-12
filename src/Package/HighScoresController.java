package Package;

public class HighScoresController {

	private HighScore game;

	public void initData(HighScore game) {
		this.game = game;
	}

	private void returnScore() {
		game.setScore(0);
		game.setGameToDone();
	}
}