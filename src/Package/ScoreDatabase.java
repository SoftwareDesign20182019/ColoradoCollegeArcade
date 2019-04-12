package Package;

import java.sql.*;
import java.util.*;

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
    public boolean createTable(String tableName) {
        String tableValues = "id int NOT NULL AUTO_INCREMENT, " +
                "name varchar(3) NOT NULL, " +
                "score varchar(50) NOT NULL, " +
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
    public void addScore(String table, String name, String score) {
        createTable(table);
        String sql = "insert into " + table + " (name, score) values ('" + name + "', " + score + ")";
        try {
//        	Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO error handling if the table doesn't exist?
     * Returns the top ten scores from a game
     * @param table - the game to retrieve high scores from
     * @return LinkedHashMap<String ,   String> - the hashmap of the top ten names and scores
     */
    public LinkedHashMap<String, String> getScores(String table) {
        String sql = "SELECT name, score FROM " + table;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                hashMap.put(rs.getString(1), rs.getString(2));
            }
            System.out.println(hashMap);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(sortHashMapByValues(hashMap));
        System.out.println(topTenScores(sortHashMapByValues(hashMap)));
        return (topTenScores(sortHashMapByValues(hashMap)));
    }

    /**
     * Sorts a hashmap by the values (scores)
     *
     * @param passedMap - the initial hashmap
     * @return - the sorted hashmap
     */
    private LinkedHashMap<String, String> sortHashMapByValues(
            HashMap<String, String> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<String> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys, Collections.reverseOrder());

        LinkedHashMap<String, String> sortedMap =
                new LinkedHashMap<>();

        Iterator<String> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            String val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                String comp1 = passedMap.get(key);
                String comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    /**
     * Returns the first ten key-value pairs of a hashmap, filling in remaining entries with "   "=0 if
     * there are less than 10 entries in the hashmap
     *
     * @param hashMap - a SORTED hashmap
     * @return the hashmap of size 10
     */
    private LinkedHashMap<String, String> topTenScores(LinkedHashMap<String, String> hashMap) {
        List<String> mapKeys = new ArrayList<>(hashMap.keySet());
        if (hashMap.size() < 10) {
            for (int i = hashMap.size(); i < 10; i++) {
                hashMap.put("   ", "0");
            }
        } else {
            for (int i = 10; i < hashMap.size(); i++) {
                hashMap.remove(mapKeys.get(i));
            }
        }
        return hashMap;
    }
}
