package orGalProject;

public abstract class Person {

	protected String userName;
	protected String password;

	public Person(String userName) throws IllegalArgumentException {
		if (userName.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.userName = userName;
		this.password = "";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) throws IllegalArgumentException {
//		if (userName.isBlank()) {
//			throw new IllegalArgumentException();
//		}
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws IllegalArgumentException {
//		if (password.isBlank()) {
//			throw new IllegalArgumentException();
//
//		}
		this.password = password;
	}

	@Override
	public String toString() {
		return "Username: " + userName + "\n";
	}
}