package config;
import java.sql.*;
public class DBConnect {

	public static Connection getConnection() {
		String DB_DRIVER =  "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/doodleblue";
		String DB_USERNAME = "root";
		String DB_PASSWORD = "Deepu@4403";
		Connection conn = null;
		try{
			//Register the JDBC driver
			Class.forName(DB_DRIVER);
 
			//Open the connection
			conn = DriverManager.
			getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
 
			if(conn != null){
			   System.out.println("Successfully connected.");
			  // Class.forName("com.sap.db.jdbc.Driver");
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   conn= DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
			}else{
			   System.out.println("Failed to connect.");
			   return conn;
			}
			}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}	
		

	}



