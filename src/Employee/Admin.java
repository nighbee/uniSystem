package Employee;
import user.*; 
import Database.*; 
import java.io.Serializable;

public class Admin extends User implements Serializable{
	
	
	
	
	private static final long serialVersionUID = 1L;
	private int salary;
	
    public Admin(){
    	
    }
    
	
    
    public Admin(String userId, String userName, String email, String address, String password, int salary) {
		super();
		this.setSalary(salary);
	}


	public boolean checkLoginPassword(String login,String password, DataBase db) {
        for(int i=0;i<db.users.size();++i) {
        	if(db.users.get(i).getUserID().equals(login) && db.users.get(i).getPassword().equals(password)) {
        		return true;
        	}
        }
        return false;
    }  

    public void addUsers(User u, DataBase db) {
    	db.addUsers(u);
    }
    
    public boolean deleteUsers(User u, DataBase db) {
    	return db.users.remove(u);
    }
    
    public String toString() {
        return super.toString();
    }
   
    

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
    
    
}