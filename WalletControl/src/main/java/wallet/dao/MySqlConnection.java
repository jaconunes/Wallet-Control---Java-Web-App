package wallet.dao;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The Class MySqlConnection.
 */
public class MySqlConnection {
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?allowPublicKeyRetrieval=true&useSSL=false", 
					"wallet", "Wallet*123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}

}
