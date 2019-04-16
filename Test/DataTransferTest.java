import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Package.Arcade;
import Package.JavelinController;
import Package.JavelinThrow;
public class DataTransferTest {
	
	private Arcade arcade;
	private JavelinThrow view;
	private JavelinController controller;
	
	@Before
	public void setUp() {
		arcade = new Arcade();
		view = new JavelinThrow();
		controller = new JavelinController();
	}

	@Test
	public void settingScoreInArcade() {
		view.setScore(10);
		view.setArcadeScore(arcade);
		assertEquals("arcade should now have score of 10",arcade.getScore(), 10);
	}
	
	@Test
	public void settingScoreInView() {
		controller.initData(view);
		controller.setControllerScore(10);
		controller.setViewScore();
		assertEquals("view should now have a score of 10", view.getViewScore(), 10);
	}

}
