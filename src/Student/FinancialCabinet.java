package Student;
import java.io.Serializable;

public class FinancialCabinet implements Serializable{
	private static final long serialVersionUID = 1L;
	Student st;
	
	FinancialCabinet(Student st){
		this.st = st;
	}
	
	
	private int studentBalance = 0;

	public int getStudentBalance() {
		return studentBalance;
	}

	public void setStudentBalance(int studentBalance) {
		this.studentBalance = studentBalance;
	}
	
	public String toString() {
		return "Student id: " + st.getUserID() + "\nStudent name: " + st.getUserName() + "\nBalance: " + studentBalance;
	}
	
}