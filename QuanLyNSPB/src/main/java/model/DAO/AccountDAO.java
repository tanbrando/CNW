package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BEAN.Account;

public class AccountDAO {
	private final String dbName = "dulieu";
	private final String dbUsername = "root";
	private final String dbPassword = "";
	private final String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
	private Connection conn;
	private PreparedStatement ps;
	private static AccountDAO _Instance;
	
	public static AccountDAO Instance() {
		if (_Instance == null) {
			_Instance = new AccountDAO();
		}
		return _Instance;
	}
	
	private AccountDAO() {
		
	};
	
	public Account checkLogin(String username, String password) {
		Account currentAccount = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM admin WHERE `username` = '" + username + "' AND `password` = '" + password + "'"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				currentAccount = new Account(rs.getString(1), rs.getString(2),"admin");
				break;
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		return currentAccount;
	}
	
	public void CloseConn() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
			System.out.println("Error " + ex);
		}
	}
}
