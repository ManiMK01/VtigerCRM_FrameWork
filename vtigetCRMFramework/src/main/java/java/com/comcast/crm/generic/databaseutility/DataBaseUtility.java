package java.com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn;
	
	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 */
	public void getDbconnection(String url, String userName, String password) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			
		}
	}
	
	public void getDbconnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbs:mysql://localhost:3306", "root", "root");
		} catch (Exception e) {
			
		}
	}
	
	public void closeDbconnection() {
		try {
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	/**
	 * 
	 * @param query
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet executeConSelectQuery(String query) throws SQLException {
		ResultSet result = null;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);
			
		} catch (Exception e) {
			
		}
		return result;
	}
	
	/**
	 * 
	 * @param query
	 * @return int
	 */
	public int executeNonSelectQuery(String query) {
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
			
		}
		return result;
	}
	
}
