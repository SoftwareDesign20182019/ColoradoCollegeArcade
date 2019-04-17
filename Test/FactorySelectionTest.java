import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Package.GameFactory;

public class FactorySelectionTest {

	private GameFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new GameFactory();
	}

	@Test
	public void validNumber() throws Exception {
		assertNotNull("valid number should return game", factory.selectGame(2));
	}
	
	@Test
	public void invalidNumber() throws Exception {
		assertNull("invalid number should return null", factory.selectGame(9));
	}

}
