package model.BEAN;

public class Department {
	private String id;
	private String name;
	private String detail;
	
	public Department(String id, String name, String detail) {
		this.id = id;
		this.name = name;
		this.detail = detail;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDetail() {
		return detail;
	}
}
