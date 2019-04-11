package Package;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreDatabaseTest {
    private ScoreDatabase database;
    private Game random;
    private static final String DATABASE_NAME = "ArcadeGames";

    @Before
    public void setUp(){
        database = new ScoreDatabase(DATABASE_NAME);
        random = new RandomScore();
    }

    @Test
    public void createConnectionTest(){
        assertTrue(database.createConnection(DATABASE_NAME));
    }

    @Test
    public void createTableTest(){
        assertTrue(database.createTable(random.getName()));
    }

    @Test
    public void addScoreTest(){
        assertTrue(database.addScore(random.getName(), "tst", random.playGame()));
    }

    @Test
    public void getScoresTest(){
//        assertTrue(database.getScores(random.getName()));
        assertNotNull(database.getScores2(random.getName()));
    }

}