package model.BO;

import java.util.ArrayList;

import model.BEAN.Department;
import model.DAO.DepartmentDAO;

public class DepartmentBO {
	public static ArrayList<Department> getDepartmentList() {
		return DepartmentDAO.Instance().getDepartmentList();
	}
	
	public static ArrayList<String> getDepartmentIDList() {
		return DepartmentDAO.Instance().getDepartmentIDList();
	}
	
	public static Department getDepartment(String id) {
		return DepartmentDAO.Instance().getDepartment(id);
	}
	
	public static void editDepartment(String id, String name, String detail) {
		DepartmentDAO.Instance().editDepartment(id, name, detail);
	}
}
