package ed_ev2_proyecto_BLOG;

public class User {
	//Properties
	private String username;

	//Constructors
	public User(String username) {
		this.username = username;
	}

	//Methods
	public String getUsername() {
		return username;
	}

	public String changeUsername(String newUsername){
		if (newUsername == null || newUsername.isEmpty()) {
			return "It couldn't be possible to change the user of " + username;
		}
		//actualiza el nuevo usuario, ahora oldUsername se queda con el valor de username
		String oldUsername = this.username;
		this.username = newUsername;
		return "Username changed from "+ oldUsername + " to " + newUsername;
	}


}
