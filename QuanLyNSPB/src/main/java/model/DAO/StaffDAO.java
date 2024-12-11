package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BEAN.Staff;

public class StaffDAO {
	private final String dbName = "dulieu";
	private final String dbUsername = "root";
	private final String dbPassword = "";
	private final String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
	private Connection conn;
	private PreparedStatement ps;
	private static StaffDAO _Instance;
	
	public static StaffDAO Instance() {
		if (_Instance == null) {
			_Instance = new StaffDAO();
		}
		return _Instance;
	}
	
	private StaffDAO() {
		
	};
	
	public ArrayList<Staff> getStaffList() {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM nhanvien"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Staff newStaff = new Staff(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4));
				staffList.add(newStaff);
			}
		} catch (Exception  e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		return staffList;
	}
	
	public ArrayList<Staff> getSearchedStaffList(String searchObject, String searchData) {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM nhanvien WHERE `"+ searchObject +"` = '" + searchData + "'"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Staff newStaff = new Staff(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4));
				staffList.add(newStaff);
			}
		} catch (Exception  e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		return staffList;
	}
	
	public ArrayList<String> getStaffIDList() {
		ArrayList<String> idList = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT IDNV FROM nhanvien"; 
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
	
	public ArrayList<Staff> getDepartmentStaffList(String department_id) {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT * FROM nhanvien WHERE `IDPB` = '" + department_id + "'"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Staff newStaff = new Staff(rs.getString(1),rs.getString(3),rs.getString(2),rs.getString(4));
				staffList.add(newStaff);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
		
		return staffList;
	}
	
	public void addStaff(String id, String department_id, String name, String address) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "INSERT INTO nhanvien (`IDNV`,`IDPB`,`Hoten`,`Diachi`) VALUES('"+ id + "','" + department_id + "','" + name + "','" + address +"')"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
	}
	
	public void editStaff(String id, String department_id, String name, String address) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "UPDATE nhanvien SET `IDPB` = '" + department_id + "', `Hoten` = '" + name + "', `Diachi` = '" + address +"' WHERE `IDNV` = '" + id + "'"; 
			conn = DriverManager.getConnection(url, dbUsername, dbPassword);
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();	
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			CloseConn();
		}
	}
	
	public void deleteStaff(String id){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "DELETE FROM nhanvien WHERE `IDNV` = '" + id + "'"; 
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
