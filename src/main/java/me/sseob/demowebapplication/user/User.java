package me.sseob.demowebapplication.user;

public class User {
	private String username;
	private Long id;
	private String password;

	public User(String username, Long id, String password) {
		this.username = username;
		this.id = id;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
