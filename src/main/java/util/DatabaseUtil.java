package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/bank";
    private static final String USER = "postgres";
    private static final String PASSWORD = "post";
    
	static {
	    try {
	        Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("PostgreSQL JDBC Driver not found!");
	        e.printStackTrace();
	    }
	}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
