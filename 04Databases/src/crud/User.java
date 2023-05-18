package crud;

public class User {
	private String name;
	private String password;
	
	public User() {
		
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [user=" + name + ", password=" + password + "]";
	}
	
	public String getName() {
		return name;
	}
	public void name(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
