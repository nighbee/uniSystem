package Compare;
import java.io.Serializable;
import java.util.*;
import user.*; 
import user.*
; 
import Student.*; 

public class CompareByGpa implements Comparator<User> ,Serializable{
   
	private static final long serialVersionUID = 1L;
	public int compare(User o1, User o2) {
		double a = ((Student)o1).calculateGpaTotal();
		double b = ((Student)o2).calculateGpaTotal();
		if(Double.compare(a, b) == 0) return 0;
		else if(Double.compare(a, b) > 0) return 1;
		else return -1;
	}  
	
	
}