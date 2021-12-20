package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static final String Host = "127.0.0.1";
	static final String Port = "3306";
	static final String DB_NAME = "Mutuelle_centralisee";
	static final String USER = "root";
	static final String PASSWORD = "root";
	
	
	private static Connection cnx ;
	
	public static Connection getConnection() {
		
		try {
			
			cnx= DriverManager.getConnection("jdbc:mysql://"+Host+":"+Port+"/"+DB_NAME+"?characterEncoding=latin1&useConfigs=maxPerformance",USER,PASSWORD);
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return cnx;
	
		
		
	}
	
	

}
