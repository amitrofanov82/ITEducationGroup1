package lesson77.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SimpleConnectionMain {

	//jdbc:postgresql://hostname:port/dbname","username", "password")
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(
			"jdbc:postgresql://localhost:5432/eCommercePlatform",
			"postgres", "admin");
		Statement statement = conn.createStatement();
		ResultSet r = statement.executeQuery("SELECT * from users");
		r.next();
		System.out.println(r.getString("name"));
		r.next();
		System.out.println(r.getString("name"));
		r.next();
		System.out.println(r.getString("name"));
		r.next();
		System.out.println(r.getString("name"));
		
		System.out.println("bye-bye");
	}
	
	
	/*String url = 
			"jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
	Connection conn = DriverManager.getConnection(url2);
	String url = "jdbc:postgresql://localhost/test";
	Properties props = new Properties();
	props.setProperty("user","fred");
	props.setProperty("password","secret");
	props.setProperty("ssl","true");
	Connection conn = DriverManager.getConnection(url, props);
	*/
	
	
	
}
