package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BEAN.Department;

public class DepartmentDAO {
	private final String dbName = "dulieu";
	private final String dbUsername = "root";
	private final String dbPassword = "";
	private final String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
	private Connection conn;
	private PreparedStatement ps;
	private static DepartmentDAO _Instance;
	
	public static DepartmentDAO Instance() {
		if (_Instance == null) {
			_Instance = new DepartmentDAO();
		}
		return _Instance;
	}
	
	private DepartmentDAO() {
		
	};
	
	public ArrayList<Department> getDepartmentList() {
		ArrayList<Department> departmentList = new ArrayList<Department>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM phongban"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Department newDepartment = new Department(rs.getString(1),rs.getString(2),rs.getString(3));
				departmentList.add(newDepartment);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		return departmentList;
	}
	
	public ArrayList<String> getDepartmentIDList() {
		ArrayList<String> idList = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT IDPB FROM phongban"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				idList.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		
		return idList;
	}
	
	public Department getDepartment(String id) {
		Department department = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM phongban WHERE `IDPB` = '" + id + "'"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				department = new Department(rs.getString(1),rs.getString(2),rs.getString(3));
				
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		return department;
	}
	
	public void editDepartment(String id, String name, String detail) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "UPDATE phongban SET `Tenphongban` = '" + name + "', `Mota` = '" + detail +"' WHERE `IDPB` = '" + id + "'"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
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
