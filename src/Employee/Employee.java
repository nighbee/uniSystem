package Employee;
import user.*; 
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;
import Database.*; 
public abstract class Employee extends User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public Vector<Message> mailBox = new Vector<Message>();
    
	public Employee() {
		super();
	}
    public Employee(String userId, String userName, String email, String address, String password, int salary) {
		super();
		this.salary = salary;
	}

	private int salary;
    
    public int getSalary() {
        return this.salary;
    }
    
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public void sendMessage(Employee employa,Message message) {
    	employa.mailBox.add(message);
    }
    
    public void viewMessages() {
    	for(Message m : this.mailBox) {
    		System.out.println(m);
    	}
    }
    public int compareTo(Employee e) {
    	return (this.salary - e.getSalary());
    }
    
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return salary == other.salary;
	}
	@Override
	public String toString() {
		return super.toString() + "Employee [salary=" + salary + "]";
	}
   
    
    
    
}