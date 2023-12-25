package user;
import Database.*; 
import java.io.Serializable;
import java.util.Objects; 
public abstract class User implements Serializable {
	private static final long serialVersionUID=1L; 
	public String userID; 
	public String userName; 
	public  String email; 
	public  String password; 
	
	public User(){ 
		
	}

	public User(String userID, String userName, String email, String password) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, userID, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(userID, other.userID) && Objects.equals(userName, other.userName);
	}
	
	public void viewNews(DataBase db) { 
		for (News i : db.news) { 
			System.out.print(i);
		}
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
}