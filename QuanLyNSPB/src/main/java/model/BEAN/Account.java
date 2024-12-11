package model.BEAN;

public class Account {
	private String username;
	private String password;
	private String role;
	
	public Account(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	
}
