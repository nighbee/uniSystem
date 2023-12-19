package user;
import Student.*; 
import Employee.*; 
public class UserFactory {

	public static User getUser(String type) {
		if (type.equals("Student")) {
			return new Student();
		} else if (type.equals("Manager")) {
			return new Manager();
		} else if (type.equals("Teacher")) {
			return new Teacher();
		}
		return null;
	}
	
	
	
}