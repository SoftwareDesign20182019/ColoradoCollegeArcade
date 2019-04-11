package Package;

import java.sql.*;

/**
 * Class for accessing the high score database
 * Can create a connection, create a table for a game, and add and get scores
 */
public class ScoreDatabase {
    private static final String PORT_NUMBER = "8889";
    private Connection conn;
    private Statement stmt;

    /**
     * Constructor that creates a connection with the database, or creates a new one if there is not one already
     *
     * @param databaseName - the name of the database
     */
    public ScoreDatabase(String databaseName){
        createConnection(databaseName);
    }


    /**
     * Creates a connection to the server and database and creates a database with databaseName if one does not already exist
     * @param databaseName - the name of the database to open a connection to or create if not already made
     */
    public boolean createConnection(String databaseName) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/?user=root&password=root&serverTimezone=UTC", "root", "root");
            stmt = conn.createStatement();
            String sql = "create database if not exists " + databaseName;
            stmt.execute(sql);
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:" + PORT_NUMBER + "/" + databaseName + "?user=root&password=root&serverTimezone=UTC"); // MySQL
            stmt = conn.createStatement();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Creates a table if one does not already exist
     * @param tableName - the name of the table
     */
    public boolean createTable(String tableName)  {
        String tableValues = "id int NOT NULL AUTO_INCREMENT, " +
                "name varchar(3) NOT NULL, " +
                "score int NOT NULL, " +
                "primary key (id)";
        String sql = "create table if not exists " + tableName + " (" + tableValues + ");";
        try {
//        	Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Adds a score to the table, creating a table for the game if one does not exist already
     * @param table - the game
     * @param name - the 3 character name
     * @param score - the score
     */
    public boolean addScore(String table, String name, int score) {
        createTable(table);
        String sql = "insert into " + table + " (name, score) values ('" + name + "', " + score + ")";
        try {
//        	Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * TODO error handling if the table doesn't exist?
     * Gets the scores from a table (game)
     * @param table - the game to retrieve high scores from
     */
    public boolean getScores(String table) {
        String sql = "SELECT name, score FROM " + table;
        try {
//        	Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int[] getScores2(String table) {
        int count = 0;
        try {
            ResultSet rset = stmt.executeQuery("select score from " + table);
            while (rset.next()) {
                count++;
            }
            int[] ids = new int[count];
            rset = stmt.executeQuery("select score from " + table);
            count = 0;
            while (rset.next()) {
                ids[count] = rset.getInt("id");
                count++;
            }
            return ids;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getScores3(String table){
        try {
            ResultSet rs = stmt.executeQuery("SELECT score FROM " + table);
            while(rs.next()){
                System.out.println(rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
