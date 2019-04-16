import java.sql.*;

public class ScoreDatabase {
    private static final String PORT_NUMBER = "8889";
    private Statement stmt;

    public ScoreDatabase() {
//        createConnection("ArcadeGames");
//        System.out.println("created connection");
    }
    
    public void createDatabase(String databaseName) {
		try (
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/", 
						"root", "root");
				Statement stmt = connection.createStatement();
				) {
			String sql = ("create database if not exists " + databaseName);
			stmt.execute(sql);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}


    /**
     * Creates a connection to the server and database and creates a database with databaseName if one does not already exist
     * @param databaseName - the name of the database to open a connection to or create if not already made
     */
    public void createConnection(String databaseName) {

        try {
<<<<<<< HEAD
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/?user=root&password=root&serverTimezone=UTC", "root", "root");
            //stmt = conn.createStatement();
            //String sql = "create database if not exists " + databaseName;
            //stmt.execute(sql);
=======
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/?user=root&password=root&serverTimezone=UTC", "root", "root");

            stmt = conn.createStatement();
            String sql = "create database if not exists " + databaseName;
            stmt.execute(sql);
>>>>>>> 522da932a0dd1b2afd08ded1b2319938d26e1ea3
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:" + PORT_NUMBER + "/" + databaseName + "?user=root&password=root&serverTimezone=UTC"); // MySQL
            //stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a table if one does not already exist
     * @param tableName - the name of the table
     */
    public void createTable(String tableName)  {
        String tableValues = "id int NOT NULL AUTO_INCREMENT, " +
                "name varchar(3) NOT NULL, " +
                "score int NOT NULL, " +
                "primary key (id)";
        String sql = "create table if not exists " + tableName + " (" + tableValues + ");";
        try {
        	Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addScore(String table, String name, int score) {
        String sql = "insert into " + table + " (name, score) values ('" + name + "', " + score + ")";
        try {
        	Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getScores(String table) {
        String sql = "SELECT name, score FROM " + table;
        try {
        	Statement stmt = this.conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args){
////        ScoreDatabase database = new ScoreDatabase("ArcadeGames");
//    }
}
