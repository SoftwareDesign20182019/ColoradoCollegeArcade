import Package.Arcade;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class gameChoosingTest {
	private Arcade arcade;
	
	@Before
	public void setUp() {
		arcade = new Arcade();
	}
	
	@Test
	public void createAGame() {
		assertNotNull(arcade.runNewGame(1));
	}
	
	@Test
	public void givesCorrectGame() {
		assertEquals(arcade.runNewGame(1), "RandomScore");
	}
	
	@Test
	public void nullIfNoGame() {
		assertNull(arcade.runNewGame(10));
	}

}
