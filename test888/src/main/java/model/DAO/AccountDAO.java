package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

    public boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM account WHERE username =? AND password =?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            return ps.executeQuery().next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    public void closeConnection() {
        try {
            if (ps!= null) ps.close();
            if (conn!= null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
