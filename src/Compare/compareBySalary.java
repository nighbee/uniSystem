package Compare;
import Employee.*; 
import java.io.Serializable;
import java.util.Comparator;

public class compareBySalary implements Comparator<Employee> ,Serializable{
	private static final long serialVersionUID = 1L;
	public int compare(Employee o1, Employee o2) {
		return o2.getSalary() -o1.getSalary();
	}   
}