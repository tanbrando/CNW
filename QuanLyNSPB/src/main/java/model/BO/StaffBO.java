package model.BO;

import java.util.ArrayList;

import model.BEAN.Staff;
import model.DAO.StaffDAO;

public class StaffBO {
	public static ArrayList<Staff> getStaffList() {
		return StaffDAO.Instance().getStaffList();
	}
	
	public static ArrayList<Staff> getSearchedStaffList(String searchObject, String searchData) {
		return StaffDAO.Instance().getSearchedStaffList(searchObject,searchData);
	}
	
	public static ArrayList<Staff> getDepartmentStaffList(String id) {
		return StaffDAO.Instance().getDepartmentStaffList(id);
	}
	
	public static ArrayList<String> getStaffIDList() {
		return StaffDAO.Instance().getStaffIDList();
	}
	
	
	
	public static void addStaff(String id, String department_id, String name, String address) {
		StaffDAO.Instance().addStaff(id, department_id, name, address);
	}
	
	public static void editStaff(String id, String department_id, String name, String address) {
		StaffDAO.Instance().editStaff(id, department_id, name, address);
	}
	
	public static void deleteStaff(String id) {
		StaffDAO.Instance().deleteStaff(id);
	}
}
