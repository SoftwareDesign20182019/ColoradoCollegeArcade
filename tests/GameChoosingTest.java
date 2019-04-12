import Package.Arcade;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameChoosingTest {
	private Arcade arcade;
	
	@Before
	public void setUp() {
		arcade = new Arcade();
	}
	
	@Test
	public void createAGame() {
		try {
			assertNotNull(arcade.runNewApplication(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void givesCorrectGame() {
		try {
			assertEquals(arcade.runNewApplication(1), "RandomScore");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void nullIfNoGame() {
		try {
			assertNull(arcade.runNewApplication(10));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
