package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection conn = null;

    public Connection getConnection() {
    	
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Step 2: Define the connection URL, username, and password
           //String url = "jdbc:mysql://localhost/:3306/fullstack_ecommerce?autoReconnect=true&useSSL=false";
            //String username = "root"; // replace with your MySQL username
            //String password = "apex12345"; // replace with your MySQL password

            // Step 3: Establish the connection
            final String DB_URL="jdbc:mysql://localhost:3306/fullstack_ecommerce?connectTimeout=1000&sockerTimeout=30000";
            final String USERNAME="root";
            final String PASSWORD="";
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            
            

        } catch (Exception e) {
            e.printStackTrace();
            conn = null;
        }
        return conn;
    }
}
