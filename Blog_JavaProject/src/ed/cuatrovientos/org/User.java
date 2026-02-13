package ed.cuatrovientos.org;

public class User {
	//Properties
	private String username;

	//Constructor
	public User(String username) {
		this.username = username;
	}

	//Methods
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return username;
	}
}
