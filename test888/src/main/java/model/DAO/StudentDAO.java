package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.BEAN.Student;

public class StudentDAO {
    private final String dbName = "test888";
	private final String dbUsername = "root";
	private final String dbPassword = "";
	private final String url = "jdbc:mysql://127.0.0.1:3306/" + dbName;
	private Connection conn;
	private PreparedStatement ps;
	private static StudentDAO _Instance;
	
	public static StudentDAO Instance() {
		if (_Instance == null) {
			_Instance = new StudentDAO();
		}
		return _Instance;
	}
	
	private StudentDAO() {
		
	};

    public ArrayList<Student> getStudentList() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String department = rs.getString("department");
                students.add(new Student(id, name, gender, department));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return students;
    }

    public ArrayList<String> getStudentIdList() {
        ArrayList<String> studentIds = new ArrayList<>();
        String sql = "SELECT id FROM sinhvien";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                studentIds.add(id);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return studentIds;
    }

    public Student getStudentById(String id) {
        Student student = null;
        String sql = "SELECT * FROM sinhvien WHERE id=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String department = rs.getString("department");
                student = new Student(id, name, gender, department);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return student;
    }

    public ArrayList<Student> getDepartmentStudentList(String department) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien WHERE department=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                students.add(new Student(id, name, gender, department));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return students;
    }

    public ArrayList<String> getStudentDepartmentList() {
        ArrayList<String> departmentList = new ArrayList<>();
        String sql = "SELECT DISTINCT department FROM sinhvien";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String department = rs.getString("department");
                departmentList.add(department);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return departmentList;
    }

    public void addStudent(String id, String name, String gender, String department) {
        String sql = "INSERT INTO sinhvien(id, name, gender, department) VALUES(?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, department);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

     public void updateStudent(String id, String name, String gender, String department) {
        String sql = "UPDATE sinhvien SET name=?, gender=?, department=? WHERE id=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, department);
            ps.setString(4, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
     }

     public void deleteStudent(String id) {
        String sql = "DELETE FROM sinhvien WHERE id=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
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
