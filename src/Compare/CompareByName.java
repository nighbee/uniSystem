package Compare;
import user.*; 
import java.io.Serializable;
import java.util.Comparator;

public class CompareByName implements Comparator<User> ,Serializable{
	
	private static final long serialVersionUID = 1L;	
	public int compare(User o1, User o2) {
		return o1.getUserName().compareTo(o2.getUserName());
	}

}