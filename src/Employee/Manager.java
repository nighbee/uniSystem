package Employee;
import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;
import enums.*; 
import Database.*; 
import Student.*; 

; public class Manager extends Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	ManagerTypes typeOfManager;

	public Manager() {

	}

	public Manager(String userId, String userName, String email, String address, String password, int salary,
			ManagerTypes typeOfManager) {
		super(userId, userName, email, address, password, salary);
		this.typeOfManager = typeOfManager;
	}

//	public void assignCourse(Course c, Teacher t) {
//		t.teacherCourses.add(c);
//	}

	public void addCourse(Course c, DataBase db) {
		db.courses.add(c);
	}

	public ManagerTypes getManagerTypes() {
		return ManagerTypes.OR;
	}

	public void manageNews(DataBase db, News news) {
		db.news.add(news);
	}

	public void makeReport(DataBase db) {
		for (Student st : db.students) {
			for (Entry<Course, Marks> entry : st.attestations.entrySet()) {
				if ((entry.getValue().getAllPoints(st, entry.getKey()) < 30)) {
					int temp = db.failOfStudents.get(st);
					temp += 1;
					db.failOfStudents.replace(st, temp);
				}
			}
		}
		for (Entry<Student, Integer> entry : db.failOfStudents.entrySet()) {
			if (entry.getValue() > 3) {
				db.users.remove(entry.getKey());
				db.students.remove(entry.getKey());
				System.err.println("Student " + entry.getKey().getUserName() + " expelled! ");
			}
		}
	}

}