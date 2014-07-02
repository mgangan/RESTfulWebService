package passwordmanager;

public class User {
	private long id;
	private String name;
	private String password;

	public User(long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public User setId(long id) {
		this.id = id;
		return this;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

}