import Package.ScoreDatabase;
import Package.Game;
import Package.JavelinThrow;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ScoreDatabaseTest {
    private static final String DATABASE_NAME = "TestDatabase";
    private ScoreDatabase database;
    private Game javelin;

    @Before
    public void setUp() {
        database = new ScoreDatabase(DATABASE_NAME);
        javelin = new JavelinThrow();
    }

    @Test
    public void createConnectionTest() {
        assertTrue(database.createConnection(DATABASE_NAME));
    }

    @Test
    public void createTableTest() {
        assertTrue(database.createTable(javelin.toString()));
    }

    @Test
    public void addScoreTest() {
        assertTrue(database.addScore(javelin.toString(), "tst", 18));
    }

    @Test
    public void getScoresTest() {
        assertNotNull(database.getScores(javelin.toString()));
    }

}