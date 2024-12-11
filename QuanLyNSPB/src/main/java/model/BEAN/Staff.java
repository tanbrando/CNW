package model.BEAN;

public class Staff {
	private String id;
	private String department_id;
	private String name;
	private String address;
	
	public Staff(String id, String department_id, String name, String address) {
		this.id = id;
		this.department_id = department_id;
		this.name = name;
		this.address = address;
	}
	
	public String getID() {
		return id;
	}
	
	public String getDepartmentID() {
		return department_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
}
